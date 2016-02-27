package graph;

public class GraphAdjMatrix {

private int adjMatrix[][];
public int vertexCount;
public GraphAdjMatrix(int vertexCount)
{
	this.vertexCount=vertexCount;
	adjMatrix=new int[vertexCount][vertexCount];
}

public void addEdge(int i,int j, int dist)
{
adjMatrix[i][j]=dist;	
}


	
}
