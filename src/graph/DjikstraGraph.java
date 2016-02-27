package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DjikstraGraph {

HashMap<String,DjikstraNode> graph;

DjikstraGraph(DjikstraEdge[] edges)
{
graph=new HashMap<String,DjikstraNode>();
for(DjikstraEdge e:edges)
{
	if(!graph.containsKey(e.start.name))
	{
		graph.put(e.start.name, e.start);
	}
	if(!graph.containsKey(e.end.name))
	{
		graph.put(e.end.name, e.end);
	}
}
for(DjikstraEdge e:edges)
{
	graph.get(e.start.name).neighbours.put(e.end, e.dist);
}
}

public void djikstra(String start)
{
	if(!graph.containsKey(start))
	{	
		System.out.println("Starting Node not present");
		return;
	}
	else
	{
		DjikstraNode source=graph.get(start);
		PriorityQueue<DjikstraNode> pq=new PriorityQueue<DjikstraNode>();
		for(DjikstraNode node:graph.values())
		{
		node.prev=source==node?source:null;
		node.dist=source==node?0:Integer.MAX_VALUE;
		node.visited=source==node?true:false;
		pq.add(node);
		}
		djikstra(pq);
	}
}
private void djikstra(PriorityQueue<DjikstraNode> pq) {

	while(!pq.isEmpty())
	{
		DjikstraNode temp=pq.poll();
		if(temp.dist==Integer.MAX_VALUE)
			break;
		for(Map.Entry<DjikstraNode,Integer> node:temp.neighbours.entrySet())
		{
			final DjikstraNode currNode=node.getKey();
			int altDist=temp.dist+node.getValue();
			if(altDist<graph.get(currNode.name).dist&&currNode.visited==false)
			{	
			pq.remove(currNode);
			currNode.visited=true;
			currNode.dist=altDist;
			currNode.prev=temp;
			pq.add(currNode);
			}
		}
		
	}
}
	
public void printAll()
{
	for(DjikstraNode n:graph.values())
	{
		n.printPath();	
		System.out.println("\n");
	}
}

}
