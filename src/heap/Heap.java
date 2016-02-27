package heap;

public class Heap {
int count=0;
int array[];
int type;
int capacity;
public Heap(int[] a,int type)
{
	if(a.length<0)
		return;
	this.array=a;
	this.type=type;
	capacity=a.length;
//	System.out.println(i);
	count=0;
	for(int j=0;j<a.length;j++)
	{
	insert(a[j]);	
	}
}

public int getParent(int i) {
	if (i<0||i>count-1)
		return -1;
	return (i-1)/2;
}
public int getLeftChild(int i) {
	int left=(2*i)+1;
	if (left>count-1)
		return -1;
	return left;
}
public int getRightChild(int i) {
	int right=(2*i)+2;
	if (right>count-1)
		return -1;
	return right;	
}

public void heapify(int i)
{
	if(i<0||i>capacity-1)
		return;
	else
		if(type==1)
		{
			int max;
			int l=getLeftChild(i);
			int r=getRightChild(i);
			if(l!=-1&&array[i]<array[l])
				max=l;
			else
				max=i;
			if(r!=-1&&array[max]<array[r])
				max=r;
			if(max!=i)
			{
				int temp=array[i];
				array[i]=array[max];
				array[max]=temp;
				heapify(max);
			}
			
		}
		else
		{
			int min;
			int l=getLeftChild(i);
			int r=getRightChild(i);
			if(l!=-1&&array[i]>array[l])
				min=l;
			else
				min=i;
			if(r!=-1&&array[min]>array[r])
				min=r;
			if(min!=i)
			{
				int temp=array[i];
				array[i]=array[min];
				array[min]=temp;
				heapify(min);
			}
				
		}	
		
}

public int getMaximum()
{
	if(type==1)
	{
	if(array.length>0)
	return array[0];
	else
		return -1;
	}
	else
	{
	int max=Integer.MIN_VALUE;
	for(int i=(count+1)/2;i<count;i++)
	{
	if (array[i]>max)
	{
		max=array[i];	
	}
	}
	return max;	
		
	}	
}
public int getMinimum()
{
	if(type==2)
	{
	if(array.length>0)
	return array[0];
	else
		return -1;
	}
	else
	{
	int min=Integer.MAX_VALUE;
	for(int i=(count+1)/2;i<count;i++)
	{
	if (array[i]<min)
	{
		min=array[i];	
	}
	}
	return min;			
	}	
}


public void findAllSmall(int k,int i)
{
if(i<0||i>=count)
	return;
if(array[i]<k)
{	
System.out.print(" "+array[i]);
}
findAllSmall(k,(2*i+1));
findAllSmall(k,(2*i+2));	
}

public void mergeHeap(Heap h1,Heap h2)
{
int m=h1.capacity;
int n=h2.capacity;
if(n>m)
	return;
for(int i=0;i<n;i++)
{
if(h1.count>m)
	h1.resizeHeap();
h1.array[count]=h2.array[i];
count++;
}
for(int i=(h1.count+1)/2;i>=0;i--)
{
heapify(i);	
}
}

public Heap buildHeap(int[] a)
{
if(a.length<0)
	return null;
Heap h=new Heap(a, 1);
return h;
}


public void insert(int data)
{
	int i;
	if(type==1)
	{
	if(count==capacity)
	{
		resizeHeap();
	}
	i=count;
	while(i>0&&data>array[(i-1)/2])
	{
		array[i]=array[(i-1)/2];
		i=(i-1)/2;
	}
	array[i]=data;
	count++;
	}
	else
	{
		if(count==capacity)
		{
			resizeHeap();
		}
		i=count;
		while(i>0&&data<array[(i-1)/2])
		{
			array[i]=array[(i-1)/2];
			i=(i-1)/2;
		}
		array[i]=data;
		count++;
	}
	
}

private void resizeHeap() {
int[] old_array=new int[capacity];
System.arraycopy(array, 0, old_array,0, capacity);
this.array=new int[capacity*2];
for(int i=0;i<old_array.length;i++)
{
	array[i]=old_array[i];
}
capacity=capacity*2;
}

public int delete()
{
if(count==0)
	return -1;
else
	{
	int data=array[0];
	array[0]=array[count-1];
	count--;
	heapify(0);
	return data;
	}

}

}
