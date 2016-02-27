package graph;

import java.util.*;

public class GraphAdjList {

HashMap<GraphNode,LinkedList<GraphNode>> adjList=new HashMap<GraphNode,LinkedList<GraphNode>> ();
int vertCount;
Queue<GraphNode> q1=new LinkedList<GraphNode>();
GraphAdjList(GraphNode[] nodes,int n)
{
	for(GraphNode node:nodes)
	{
		adjList.put(node, new LinkedList<GraphNode>());
	}
	this.vertCount=n;
}
 
public void addEdge(GraphNode start,GraphNode end)
{
	LinkedList<GraphNode> srcList=adjList.get(start);
	srcList.add(end);
	LinkedList<GraphNode> endList=adjList.get(end);
	endList.add(start);
}

public void addSingleEdge(GraphNode start,GraphNode end)
{
	LinkedList<GraphNode> srcList=adjList.get(start);
	srcList.add(end);
}

public void bfsTraverse(GraphNode start)
{
	q1.add(start);
	while(!q1.isEmpty())
	{
		GraphNode temp=q1.poll();
		if(temp.visited==false)
		{
			temp.visited=true;
			System.out.println(temp.name);
			for(GraphNode b:adjList.get(temp))
			{
				q1.add(b);
			}
		}
		
	}
}

public void dfsTraverse(GraphNode start)
{
	if(start==null)
		return;
	if(start.visited!=true)	
	{
		start.visited=true;
	}	
	System.out.println("DFS "+start.name);
	while(adjList.get(start).peek()!=null)
	{
		GraphNode adj=adjList.get(start).poll();
		if(adj.visited!=true)
		{
			adj.visited=true;
			dfsTraverse(adj);
		}
	}
}

public void tSort(GraphNode a)
{
a.visited=true;
Stack<GraphNode> st=new Stack<GraphNode>();
topologicalSort(a,st);
System.out.println("Topological Sort");
while(!st.isEmpty())
{
System.out.println(st.pop().name);
}
}
private void topologicalSort(GraphNode a,Stack s)
{
if(a==null)
	return;
a.visited=true;
for(GraphNode gn:adjList.get(a))
{
if(gn.visited==false)
	{
		
		topologicalSort(gn,s);
	}
}
s.push(a);
}

}