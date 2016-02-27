package graph;

public class GraphOper {

	public static void main(String[] args)
	{
		GraphNode a1=new GraphNode("a");
		GraphNode b1=new GraphNode("b");
		GraphNode h1=new GraphNode("h");
		GraphNode c1=new GraphNode("c");
		GraphNode d1=new GraphNode("d");
		GraphNode e1=new GraphNode("e");
		GraphNode g1=new GraphNode("g");
		GraphNode f1=new GraphNode("f");
		GraphNode [] gNodes={a1,b1,c1,d1,e1,f1,h1,g1};
		GraphAdjList gralOper=new GraphAdjList(gNodes,8);
		gralOper.addEdge(a1, b1);
		gralOper.addEdge(b1, c1);
		gralOper.addEdge(a1, h1);
		gralOper.addEdge(h1, e1);
		gralOper.addEdge(c1, d1);
		gralOper.addEdge(c1, e1);
		gralOper.addEdge(e1, g1);
		gralOper.addEdge(e1, f1);
//		gralOper.bfsTraverse(a1);
		gralOper.dfsTraverse(a1);
		DjikstraNode a=new DjikstraNode("a");
		DjikstraNode b=new DjikstraNode("b");
		DjikstraNode c=new DjikstraNode("c");
		DjikstraNode d=new DjikstraNode("d");
		DjikstraNode f=new DjikstraNode("f");
		DjikstraEdge edge1=new DjikstraEdge(a,b,1);
		DjikstraEdge edge2=new DjikstraEdge(a,c,0);
		DjikstraEdge edge3=new DjikstraEdge(b,c,1);
		DjikstraEdge edge4=new DjikstraEdge(a,d,99);
		DjikstraEdge edge5=new DjikstraEdge(d,b,-200);
//		DjikstraEdge edge6=new DjikstraEdge(d,f,2);
		DjikstraEdge[] edges={edge1,edge2,edge3,edge4,edge5};
		DjikstraGraph dgraph1=new DjikstraGraph(edges);
		dgraph1.djikstra("a");
		dgraph1.printAll();
		GraphNode a2=new GraphNode("a1");
		GraphNode b2=new GraphNode("b1");
		GraphNode h2=new GraphNode("h1");
		GraphNode c2=new GraphNode("c1");
		GraphNode d2=new GraphNode("d1");
		GraphNode e2=new GraphNode("e1");
		GraphNode g2=new GraphNode("g1");
		GraphNode f2=new GraphNode("f1");
		GraphNode [] gNodes2={a2,b2,c2,d2,e2,f2,h2,g2};
		GraphAdjList gralOper2=new GraphAdjList(gNodes2,8);
		gralOper2.addSingleEdge(a2, b2);
		gralOper2.addSingleEdge(b2, c2);
		gralOper2.addSingleEdge(a2, h2);
		gralOper2.addSingleEdge(h2, e2);
		gralOper2.addSingleEdge(c2, d2);
		gralOper2.addSingleEdge(c2, e2);
		gralOper2.addSingleEdge(d2, g2);
		gralOper2.addSingleEdge(e2, f2);
		gralOper2.tSort(a2);
	}
}
