package queue;

public class Queue {
int front;
int rear;
int[] array;
int capacity;
public Queue()
{
front=-1;
rear=-1;
capacity=1;
array=new int[capacity];
}
public boolean isEmpty()
{
return front==-1;	
}
public boolean isfull()
{
	return (rear+1)%capacity==front;
}

public void enqueue(int data)
{
	if (isfull())
	{
		doublequeue();
	}
	rear=(rear+1)%capacity;
	if(rear==0)
	{
	front=rear;	
	}
	array[rear]=data;
}
public int dequeue()
{
	int data=-1;
	if(isEmpty())
	{
	return -1;	
	}
	data=array[front];
	if (front==rear)
	{	
			front=-1;
			rear=-1;
	}
	else
	front=front+1%capacity;
	return data;
}

private void doublequeue() {
	capacity=capacity*2;
	int[] oldarray=array;
	int i=0;
	array=new int[capacity];
	while(i<oldarray.length)
	{
		array[i]=oldarray[i];
		i++;
	}
}
}
