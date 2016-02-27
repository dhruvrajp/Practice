package graph;

import java.util.*;

public class ArticulationPoint {

	public static void main(String[] args)
	{
	APGraph ag=new APGraph(7);
	ag.addEdge(0, 1);
	ag.addEdge(1, 2);
	ag.addEdge(1, 3);
	ag.addEdge(2, 3);
	ag.addEdge(3, 4);
	ag.addEdge(3, 5);
	ag.cutVert(0);
	}
}

class APGraph{
int[] dfsnum;
int[] low;
int count=0;
ArrayList<Integer> [] adjList;
APGraph(int V)
{
	adjList=new ArrayList[V];
	dfsnum=new int[V];
	low=new int[V];
	Arrays.fill(dfsnum, -1);
	for (int i=0;i<V;i++)
	{
		adjList[i]=new ArrayList<Integer>();
	}
}

public void addEdge(int i,int j)
{
	adjList[i].add(j);
	adjList[j].add(i);
}

public void cutVert(int source)
{
dfsnum[source]=low[source]=count++;
for(int i:adjList[source])
{
	if(dfsnum[i]==-1)	
	{
		cutVert(i);
		low[source]=Math.min(low[source], low[i]);
		if(low[i]>=low[source])
		{
			System.out.println("Cut Vert"+i);
		}
	}
	else
	{
			low[source]=Math.min(low[source], dfsnum[i]);
	}
}

}
}