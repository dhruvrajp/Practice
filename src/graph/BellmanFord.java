package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

	public static void main(String[] a) throws Exception
	{
		Integer [][]x=new Integer[5][5];
		x[0][1]=5;
		x[0][2]=6;
		x[2][1]=-4;
		x[2][3]=1;
		x[1][4]=7;
		BellmanFord(x,0);
	}

//	http://www.geekviewpoint.com/java/graph/bellman_ford_shortest_path
	static int[][] BellmanFord(Integer[][]x,Integer source) throws Exception
	{
	
		int minDist[]=new int[x.length];
		int[] pred=new int[x.length];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		Arrays.fill(pred, -1);
		minDist[source]=0;
		for(int i=0;i<minDist.length-1;i++)
		{
			for(int v=0;v<x.length;v++)
			{
				for(int n:adjacent(x,v))
				{
					if(minDist[n]>minDist[v]+x[v][n])
					{
						minDist[n]=minDist[v]+x[v][n];
						pred[n]=v;
					}
				}
				
			}
		}
		for(int v=0;v<x.length;v++)
		{
			for(int n:adjacent(x,v))
			{
				if(minDist[n]>minDist[v]+x[v][n])
				{
					throw new Exception("Loop exists");
				}
			}
			
		}
		int result[][]={pred,minDist};
		return result;
	}

	private static List<Integer> adjacent(Integer[][] x, int v) {
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<x.length;i++)
		{
			if(x[v][i]!=null)
			result.add(i);
		}
		return result;
	}
	
	
}
