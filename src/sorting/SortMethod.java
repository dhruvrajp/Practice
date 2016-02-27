package sorting;

import java.util.ArrayList;
import java.util.List;

public class SortMethod {

	
	public int[] heapSort(int []a)
	{
	int n=a.length-1;	
	int i;
	buildHeap(a);
	for(i=a.length-1;i>=0;i--)
	{
		int temp=a[0];
		a[0]=a[i];
		a[i]=temp;
		n=n-1;
		heapify(a,0,n);
		
	}
	return a;
		
		
	}
	
	
	public void buildHeap(int[] a) {
		int n=a.length-1;
		for(int i=n/2;i>=0;i--)
		{
			heapify(a,i,n);
		}
	}


	private void heapify(int[] a, int i, int n) {
		if(i<0)
			return;
		int left=2*i;
		int right=2*i+1;
		int max=i;
		if(left<=n&&a[left]>a[i])
			max=left;
		else
			max=i;
		if(right<=n&&a[max]<a[right])
			max=right;
		if(max!=i)
		{	int temp;
			temp=a[max];
			a[max]=a[i];
			a[i]=temp;
			heapify(a,max,n);
		}
	}


	public int[] bubbleSort(int[] a)
	{
	int temp=0;
	for(int i=a.length-1;i>=0;i--)
	{
		for(int j=0;j<i-1;j++)
		{
			if(a[j]>a[j+1])
			{
				temp=a[j+1];
				a[j+1]=a[j];
				a[j]=temp;		
			}
		}
	}
	return a;
	}
	
	public int[] selectSort(int[] a)
	{
		int i,j,min,temp;
		for(i=0;i<a.length-1;i++)
		{
			min=i;
			for(j=i+1;j<=a.length-1;j++)
			{
			if(a[j]<a[min])
			{
			min=j;				
			}	
			}
			temp=a[i];	
			a[i]=a[min];
			a[min]=temp;
		}
		return a;
		
		
	}
	
	public int[] insertSort(int[] a)
	{
		int i,j,v;
	for(i=1;i<a.length;i++)
	{
		v=a[i];
		j=i;
		while(j>=1&&a[j-1]>v)
		{
			a[j]=a[j-1];
			j--;
		}
		a[j]=v;
	}
	return a;	
	}
	
	public void mergeSort(int[] a)
	{
		int[] temp=new int[a.length];
		msSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
		{
		System.out.println(" "+a[i]);	
			
		}
	}

	private int[] msSort(int[] a, int left, int right) {
	int mid;
	if(right>left)
	{
		mid=(right+left)/2;
		msSort(a,left,mid);
		msSort(a,mid+1,right);
		merge(a,left,mid,right);
	}
	return a;
	}

	private int[] merge(int[] a, int left, int mid, int right) {
	int[] temp=new int[a.length];
	for(int n=left;n<=right;n++)
	{
	temp[n]=a[n];	
	}
	int pos=left;
	int size=right-left+1;
	int i=left;
	int j=mid+1;
	while(i<=mid&&j<=right)
	{
	if(temp[i]<temp[j])
	{
	a[pos]=temp[i];
	pos++;
	i++;
	}
	else
	{
	a[pos]=temp[j];
	pos++;
	j++;
	}	
	}
	while(i<=mid)
	{
	a[pos]=temp[i];
	pos++;
	i++;
	}
	while(j<=right)
	{
	a[pos]=temp[j];
	pos++;
	j++;
	}
	return a;
	}

public int[] shellSort(int[] a)
{
int i,j,h,v;
for(h=(a.length-1)/2;h>0;h=(int)(h==2?1:h/2.2))
{
	for(i=h;i<a.length;i++)
	{
		v=a[i];
		j=i;
		while(j>h-1&&v<a[j-h])
		{
		a[j]=a[j-h];
		j=j-h;
		}
		a[j]=v;
		
	}
}
return a;
}

public int[] quickSort(int[] a,int low,int high)
{
int pivot;
if(high>low)
{
pivot=partition(a,low,high);
quickSort(a,low,pivot-1);
quickSort(a,pivot+1,high);
}	
return a;	
}

private int partition(int[] a, int low, int high) {
	int pivot=a[high];
	int i=low;	
	int j;
	int temp;
	for(j=low;j<high;j++)
	{
		if(a[j]<=pivot)                                                                                                                                                                                                                                                                                                                                                                                                               
		{
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			i=i+1;
		}
	}
	temp=a[i];
	a[i]=a[high];
	a[high]=temp;
	return i;
}

public int[] countingSort(int[] a,int K)
{
int[] b=new int[K+1];
int[] c=new int[a.length];
System.out.println(a.length);
for(int i=0;i<b.length;i++)
{
	b[i]=0;
}
for(int i=0;i<a.length;i++)
{
b[a[i]]=b[a[i]]+1;	
}
for(int i=1;i<b.length;i++)
{
b[i]=b[i]+b[i-1];
}
for(int i=a.length-1;i>=0;i--)
{
c[b[a[i]]-1]=a[i];	
b[a[i]]=b[a[i]]-1;
}
return c;
}

public int[] bucketSort(int[] A,int K)
{
int[] bucket=new int[K+1];
for(int i=0;i<bucket.length;i++)
{
bucket[i]=0;	
}
for(int i=0;i<A.length;i++)
{
++bucket[A[i]];	
}
int i,j;
for(i=0,j=0;i<bucket.length;i++)
{
	for(int k=bucket[i];k>0;k--)
	{
		A[j]=i;
		j++;
	}
}

return A;
}

public int[] radixSort(int[] A,int L)
{
int place=1;	
int count=1;
List<Integer>[] bucket=new ArrayList[10];
for(int b=0;b<bucket.length;b++)
{
	bucket[b]=new ArrayList<Integer>();
}
while(count<=L)
{
	for(int i=0;i<A.length;i++)
	{	
		int in=A[i]/(place);
		int temp=in%(10);
		bucket[temp++].add(A[i]);
	}
	int a=0;
	for(int i=0;i<bucket.length;i++)
	{
		for(int iterate:bucket[i])
		{
			A[a++]=iterate;
		}
		bucket[i].clear();
	}
	place=place*10;
	count=count+1;
}
return A;	

}

}
