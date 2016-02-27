package graph;

public class DjikstraEdge {

	
	DjikstraNode start;
	DjikstraNode end;
	int dist;
	public DjikstraEdge(DjikstraNode start, DjikstraNode end, int dist) {
		this.start=start;
		this.end=end;
		this.dist=dist;
	}
	
}
