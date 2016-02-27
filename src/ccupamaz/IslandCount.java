package ccupamaz;

import java.util.*;
public class IslandCount {
	public static void main(String[] args){
		boolean[][] land={{true,false,false,true,},{false,false,true,true},{false,false,false,false}};
		int count=isIsland(land);
		System.out.println(count);
	}

	private static int isIsland(boolean[][] land) {
		boolean[][] visited=new boolean[land.length][land[0].length];
		int count=0;
		for(int i=0;i<visited.length;i++){
			for(int j=0;j<visited[0].length;j++){
				if(land[i][j]&&!visited[i][j]){
					visitAdjacent(land,visited,i,j);
					count++;
				}
			}
		}
		return count;
	}

	private static void visitAdjacent(boolean[][] land, boolean[][] visited, int i, int j) {
		Queue<IslandNode> q=new LinkedList<IslandNode>();
		visited[i][j]=true;
		q.add(new IslandNode(i,j));
		while(!q.isEmpty()){
			IslandNode node = q.poll();
			int ci = node.lefti;
			int cj = node.righti;
			if(ci+1<land.length&&land[ci+1][cj]&&!visited[ci+1][cj]){
				visited[ci+1][cj]=true;
				q.add(new IslandNode(ci+1,cj));
			}
			if(cj+1<land[0].length&&land[ci][cj+1]&&!visited[ci][cj+1]){
				visited[ci][cj+1]=true;
				q.add(new IslandNode(ci,cj+1));
			}
			if((ci+1<land.length&&cj+1<land[0].length)&&land[ci+1][cj+1]&&!visited[ci+1][cj+1]){
				visited[ci+1][cj+1]=true;
				q.add(new IslandNode(ci+1,cj+1));
			}
		}
	}
}

class IslandNode{
	int lefti,righti;
	IslandNode(int l,int r){
		lefti=l;
		righti=r;
	}
	IslandNode(){
	}
}