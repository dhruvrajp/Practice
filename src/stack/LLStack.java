package stack;

import linkedlist.ListNode;

public class LLStack {
public ListNode headnode;

public void push(int data)
{
	if(headnode==null)
	{
		headnode=new ListNode();
		headnode.setData(data);
	}
		else
	{
	ListNode LLnode=new ListNode();
	LLnode.setData(data);
	LLnode.setNext(headnode);
	headnode=LLnode;
	}
}
public int top()
{
return headnode.getData();	
}
public int pop()
{
if(headnode==null)
{
	System.out.println("Stack empty");
return -1;	
}
else
{
	int data=headnode.getData();
	headnode=headnode.getNext();
	return data;
}
}
public LLStack reversal(LLStack s)
{
int data=s.pop();
if(data==-1)
{
return s;	
}
reversal(s);
insertAtBottom(s,data);
return s;	
}

private void insertAtBottom(LLStack s, int data) {
	if(s.headnode==null)
	{
		s.push(data);
		return;
	}
	int temp=s.pop();
	insertAtBottom(s,data);
	s.push(temp);
	
}

public LLStack sort(LLStack s)
{
LLStack sr=new LLStack();
while(s.headnode!=null)
{
	int tmp=s.pop();
	while(sr.headnode!=null&&sr.top()>tmp)
	{
		s.push(sr.pop());
	}
	sr.push(tmp);
}
return sr;
}
}