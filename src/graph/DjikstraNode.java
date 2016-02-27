package graph;

import java.util.HashMap;

public class DjikstraNode implements Comparable<DjikstraNode> {

String name;
DjikstraNode prev;
boolean visited;
int dist=Integer.MAX_VALUE;
HashMap<DjikstraNode,Integer> neighbours=new HashMap<DjikstraNode,Integer>();
DjikstraNode(String name)
{
	this.name=name;
	visited=false;
}
@Override
public int compareTo(DjikstraNode dn) {
	return Integer.compare(dist, dn.dist);
}

public void printPath()
{
	if(this.prev==this)
		System.out.print(" "+this.name);
	else
	{
		this.prev.printPath();
		System.out.print("->"+this.name+this.dist);
		
	}
}

}
