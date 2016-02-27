package challenges;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MergeArray {
public static void main(String[] a)
{
int[][] arr={{1,2,5,6},{8,9,13,14},{2,23,24,25},{7,8,9}};	
PriorityQueue<MergeArrayNode> pq=new PriorityQueue<MergeArrayNode>();
int totall=0;
for(int[] ar:arr)
{
	for(int i:ar)
	{
		totall=totall+1;
	}
}
int[] result=new int[totall];
int count=0;
MergeArrayNode[] man =new MergeArrayNode[arr.length];
for(int i=0;i<arr.length;i++)
{
	man[i]=new MergeArrayNode(arr[i],0);
}
for(int i=0;i<arr.length;i++)
{
pq.add(man[i]);	
}
while(!pq.isEmpty())
{
	MergeArrayNode output=pq.remove();
	result[count++]=output.arr[output.index];
	if(output.index<output.arr.length-1)
	{
		output.index++;
		pq.add(output);	
	}
}
System.out.println(" ");
for(int i:result)
{
System.out.print(" "+i);	
}

}	
}
