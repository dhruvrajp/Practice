package sorting;

import java.util.LinkedList;

public class Sort {
public static void main(String[] args)
{
int[] a={5,15,10,2,1,0};
SortMethod bs=new SortMethod();
int[] b=bs.bucketSort(a, 15);
bs.heapSort(a);
for(int i:b)
{
System.out.print(" "+i);
}
int counter=1;
int maxcount=Integer.MIN_VALUE;
int answer=0;
for(int i=1;i<=a.length-1;i++)
{
	if(a[i]==a[i-1])
	{
		counter++;	
	}
	else
	{
		counter=1;	
	}
	if(counter>maxcount)
	{
	maxcount=counter;
	answer=a[i];
	}
}
System.out.println("\n"+answer);
int[] a1={4,3,2,0,6};
int[] b1={4,6,0,7,2};
int k=6;
addUptoK(a1,b1,k);
}


private static void addUptoK(int[] a1, int[] b1, int k) {
	SortMethod st=new SortMethod();
	st.heapSort(a1);    //O(nlogn)
	int c=0;
	for(int i=0;i<b1.length;i++)
	{
		c=k-b1[i];
		if(c<0)
		{
			c=c*-1;
		}
		else
		{
		int bs=binarySearch(a1,c);
		if(bs!=-1)
			System.out.println("Pair "+bs+","+b1[i]);
		}
	}

}

private static int binarySearch(int[] a1, int c) {
	int mid=a1.length/2;
	int[] left=new int[mid];
	int[] right=new int[a1.length-mid+1];
	if(a1[mid]==c)
		return a1[mid];
	else if(c<a1[mid])
	{
		for(int k=0;k<mid;k++)
		{
			left[k]=a1[k];
		}
		return binarySearch(left,c);
	}
	else if(c>a1[mid])
	{
			int r=0;
			for(int k=mid;k<a1.length;k++)
			{
				right[r]=a1[k];
				r++;
			}
			return binarySearch(right,c);	
	}
	else
		return -1;
}
}
