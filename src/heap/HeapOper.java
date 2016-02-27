package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HeapOper {
	public static void main(String[] a)
	{
		int[] array1={59,78,64,23,45,56};
		int[] array2={59,78,64,23,45,56};
		int[] array3={59,78,64,23,45,56};
		int[] array4={59,78,64,23,45,56};
		int ksmall=kthSmallAux(array1,4);
		int klarge=kthLargest(array2,3);
		System.out.println("kthsmall"+ksmall+"   kthlargest"+klarge);
		Heap h=new Heap(array3,1);
		h.insert(53);
		h.insert(22);
		int[] arr2={101,102};
		Heap h2=new Heap(arr2,1);
		h.mergeHeap(h,h2);
		System.out.println("Max "+h.getMaximum());
		h.findAllSmall(102, 0);
		System.out.println("\n");
//HERE STARTS kth- Nearly Sorted list Implementation
		Heap h3=new Heap(array4,2);
		int[] nearr={2, 6, 3, 12, 56, 8};
		int k=3;
		int[] temp={nearr[0],nearr[1],nearr[2]};
		int[] result=new int[nearr.length];
		int cnt=k;
		int j=0;
		Heap hnearr=new Heap(temp,2);
		while(j<nearr.length)
		{
			int ele=hnearr.delete();
			if(cnt<nearr.length)
			{	
			hnearr.insert(nearr[cnt]);
			}
			cnt++;
			result[j]=ele;
			j++;
		}
		System.out.println("result");
		for(int i:result)
		{
			System.out.print(" "+i);
		}
//ENDS HERE		

		StackHeap sh=new StackHeap();
		sh.push(0,25);
		sh.push(1,45);
		sh.push(2,36);
		sh.push(3,39);
		sh.push(4,57);
		System.out.println("\n"+"POped: "+sh.pop());
		int[] ropearr={15,5,6,10,17};
		int ans=ropeCut(ropearr);
		System.out.println("rope "+ans);
 	}

	public static int[] heapSort(int[] a)
	{
		if(a.length<0)
			return null;
		Heap h=new Heap(a,1);
		int i=a.length-1;
		while(h.count!=0&&i>=0)
		{
			int temp=h.array[0];
			h.array[0]=h.array[h.count];
			h.array[h.count]=temp;
			a[i]=temp;		
			i--;
			h.count=h.count-1;
			h.heapify(0);
		}
		return a;
	}
	
public static int kthSmallest(int[] a,int k)
{
Heap harr=new Heap(a,2);
for(int i=0;i<k-1;i++)
	harr.delete();
return harr.delete();		
}

public static int kthLargest(int[] a,int k)
{
if (k>a.length)
	return -1;
Heap harr=new Heap(a,1);
for(int i=0;i<k-1;i++)
	harr.delete();
return harr.delete();
}

public static int kthSmallAux(int[] a,int k)
{
int count=0;
int heapElement;
int i=0;
if(k>a.length-1||k<0)
	return -1;
Heap horig=new Heap(a,2);
int[] arr={a[0]};
Heap haux=new Heap(arr,2);
	while(i<horig.capacity)
	{
	heapElement=haux.delete();	
	if(++count==k)
	{
	return heapElement;
	}
	else
	{
	if(horig.getLeftChild(i)!=-1)	
	haux.insert(horig.array[horig.getLeftChild(i)]);	
	if(horig.getRightChild(i)!=-1)
	haux.insert(horig.array[horig.getRightChild(i)]);
	i++;
	}	
	}
	return -1;
}

public static int ropeCut(int[] a)
{
	PriorityQueue<Integer> pq=new PriorityQueue();
	for(int i:a)
	{
	pq.add(i);			
	}
	while(pq.size()>1)
	{
	int h1=pq.poll();
	int h2=pq.poll();
	int h3=h1+h2;
	pq.add(h3);	
	}
	return pq.poll();
}

}