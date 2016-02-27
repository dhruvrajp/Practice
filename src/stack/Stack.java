package stack;

public class Stack {
int[] array;
int capacity;
int top;
Stack()
{
capacity=1;
array=new int[capacity];
top=-1;
}
public boolean isOverFlow()
{
return (top==array.length-1);	
}
public boolean isUnderFlow()
{
return (top==-1);	
}
public int push(int data)
{
if(isOverFlow())
{
doubleStack();
}
array[++top]=data;
return top;
}
public void doubleStack()
{
	int[] arr2=new int[capacity*2];
	System.arraycopy(array, 0, arr2, 0, capacity);
	capacity=capacity*2;
	array=arr2;
}

public int pop()
{
if(isUnderFlow())
{
	System.out.println("Stack Underflow");
return -1;
}
return array[top--];	
}

public boolean isEmpty(Stack s)
{
return (s.top==-1);	
}

public Stack reversal(Stack s)
{
	if(s.isEmpty(s))
		return s;
	int data=s.pop();
	reversal(s);
	insertAtBottom(s,data);
	return s;	
}

private void insertAtBottom(Stack s, int data)
{
	if(s.isEmpty(s))
	{
		s.push(data);
		return;
	}
	int temp=s.pop();
	insertAtBottom(s,data);
	s.push(temp);
	
}


}
