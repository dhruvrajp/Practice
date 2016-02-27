package heap;

//http://www.interviewadda.com/implement-stack-heap/
public class StackHeap {
	int count=0;
	int array[]=new int[15];
	int capacity;
	public void push(int i,int data)
	{
	if(i<0||i>array.length)
		return;
	insert(i,data);
	}
	private void insert(int i, int data) {
		if(i==0)
		{
		count=i;
		array[count]=data;
		count++;
		}
		int j=count;
		while(i>(j-1)/2&&j>0)
		{
			array[j]=array[(j-1)/2];
			array[(j-1)/2]=data;
			j=(j-1)/2;
		}
		count++;
	}
	
	public int getParent(int i) {
		if (i<0||i>count)
			return -1;
		return (i-1)/2;
	}
	public int getLeftChild(int i) {
		int left=(2*i)+1;
		if (left>count)
			return -1;
		return left;
	}
	public int getRightChild(int i) {
		int right=(2*i)+2;
		if (right>count)
			return -1;
		return right;	
	}
	
	public int pop()
	{
		int data=array[0];
		array[0]=array[count];
		count--;
		return data;
	}
	
	public int Top()
	{
		return array[count];
	}

}
