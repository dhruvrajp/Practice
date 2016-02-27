package ctcode;

import java.util.*;

public class MatrixProb {
	public static void main(String[] a)
	{
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int[][] mat=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				mat[i][j]=s.nextInt();
			}
		}
		rotateImage(mat);
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.println("\n");
		}
		checkZero(mat);
		System.out.println("Zero print");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(" "+mat[i][j]);
			}
			System.out.println("\n");
		}
	}

	private static int[][] checkZero(int[][] mat) {
		if(mat==null)
			return null;
		HashMap<Integer,Integer> zeroMap=new HashMap<Integer,Integer>();
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat.length;j++)
			{
				if(mat[i][j]==0)
				{
				 zeroMap.put(i, j);
				}
			}
		}
		for(Map.Entry<Integer, Integer> me: zeroMap.entrySet())
		{
			for(int rowch=0;rowch<mat.length;rowch++)
			{
				mat[me.getKey()][rowch]=0;
			}
			for(int colch=0;colch<mat.length;colch++)
			{
				mat[colch][me.getValue()]=0;
			}
		}
		
		return mat;
		
	}

	private static void rotateImage(int[][] mat) {
		int len=mat.length;
		for(int i=0;i<len/2;i++){
			for(int j=i;j<len-i-1;j++)
			{
				int top=mat[i][j];
				mat[i][j]=mat[len-j-1][i];
				mat[len-j-1][i]=mat[len-i-1][len-j-1];
				mat[len-i-1][len-j-1]=mat[j][len-i-1];
				mat[j][len-i-1]=top;
			}
		}
		
	}
}
