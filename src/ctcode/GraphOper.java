package ctcode;

import java.util.*;
public class GraphOper {
	public static void main(String[] args){
	GraphNode gn1=new GraphNode(10);
	Graph g =new Graph(gn1);
	GraphNode gn2=new GraphNode(20);
	GraphNode gn3=new GraphNode(30);
	GraphNode gn4=new GraphNode(40);
	GraphNode gn5=new GraphNode(50);
	g.addEdge(gn1, gn2);
	g.addEdge(gn1, gn3);
	g.addEdge(gn2, gn4);
	g.addEdge(gn3, gn5);
	System.out.println(g.checkPath(gn1, gn5));
	}
}


class Graph{
	GraphNode root;
	Graph(GraphNode root){
		this.root=root;
	}
	public void addEdge(GraphNode n1,GraphNode n2){
		n1.adj.add(n2);
	}
	public boolean checkPath(GraphNode n1,GraphNode n2){
		if(n1==null)
			return false;
		for(GraphNode n:n1.adj){
			if(n.data==n2.data){
				return true;
			}
			else{
				boolean curr = checkPath(n,n2);
				if(curr==true)
					return true; 
			}
		}
		return false;
	}
}

class GraphNode{
	ArrayList<GraphNode> adj=new ArrayList<GraphNode>();
	int data;
	GraphNode(int data){
		this.data=data;
	}
	
}