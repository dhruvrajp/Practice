package linkedlist;

import dll.DLLNode;

public class LinkedList {

	ListNode headnode;
	LinkedList(ListNode h){
		this.headnode=h;
	}
	public void traverse(ListNode headnode)
	{
	ListNode current=headnode;
	while(current!=null)
	{
		System.out.println("Node data  "+current.getData());
		current=current.getNext();
	}
		
	}
	public int search(ListNode headnode,int data)
	{
		System.out.println(System.currentTimeMillis());
		ListNode  current=headnode;
		int i=1;
		if(data==headnode.getData())
		{
			System.out.println("Found at head node ");
		}
		else
		{
		while(current.getNext()!=null)
		{
			if(data==current.data)
			{
			System.out.println("Found at position "+i);	
			return i;
			}
			else
			{
			current=current.getNext();
			i++;
			}
		}
		}
		System.out.println(System.currentTimeMillis());
		return i;
	}
	
	public ListNode insert(ListNode headnode,ListNode insertnode,int position)
	{
		int i=1;
		if(headnode==null)
			return insertnode;
		int len=length(headnode);
		if(position<1||position>len+1)
		{
			System.out.println("Invalid pos "+len);
			return headnode;
		}
		else
		{
			if(position==1)
			{
				insertnode.setNext(headnode);
				return insertnode;
			}
			else
			{	
				ListNode prev=headnode;
				while(i<position-1)
				{
					prev=prev.getNext();
					i++;
				}
				ListNode current=prev.getNext();
				prev.setNext(insertnode);
				insertnode.setNext(current);
			}
		}
		return insertnode;
	}
	public ListNode delete(ListNode headnode,ListNode insertnode,int position)
	{
		int i=1;
		int len=length(headnode);
		if(position<1||position>len+1)
		{
			System.out.println("Invalid pos "+len);
			return headnode;
		}
		else
		{
			if(position==1)
			{
				ListNode currentnode=headnode.getNext();
				headnode=null;
				return currentnode;
			}
			else
			{	
				ListNode prev=headnode;
				while(i<position-1)
				{
					prev=prev.getNext();
					i++;
				}
				ListNode current=prev.getNext();
				prev.setNext(current.getNext());
				current=null;
			}
		}
		return insertnode;
	}
	
	public int length(ListNode headnode)
	{
		ListNode current=headnode;
		int i=0;
		while(current!=null)
		{
			i++;
			current=current.getNext();					
		}
		return i;
		
	}
	
	public ListNode reversal(ListNode headnode)
	{
	ListNode temp=null,next=null;
	while(headnode!=null)
	{
		next=headnode.getNext();
		headnode.setNext(temp);
		temp=headnode;
		headnode=next;
	}
		return temp;
	}
	
	public ListNode midpoint(ListNode headnode)
	{
	int i=0;
	ListNode ptr1=null,ptr2=null;
	ptr1=headnode;
	ptr2=headnode;
	while(ptr1.getNext()!=null)
	{
		if(i==0)
		{
			ptr1=ptr1.getNext();
			i=1;
		}
		else
		{
			ptr1=ptr1.getNext();
			ptr2=ptr2.getNext();
			i=0;
		}
	}
	System.out.println("MId "+ptr2.getData());
	return ptr2;
	}
	
	public void printrev(ListNode head)
	{
		if (head==null)
			return;
		else
		{
			printrev(head.getNext());
			System.out.println(head.getData());
			
		}
	}
	public ListNode revinpair(ListNode head)
	{
	ListNode head1=head;
	ListNode tail1=head.getNext();
	if(head1==null||tail1==null)
	{ return head1; }
	else
	{
	ListNode temp=tail1;
	tail1=head1;
	head1=temp;
	revinpair(head1.getNext());
	System.out.println("Reversing in pairs "+head1.getData()+" "+tail1.getData());
	}
	return head1;	
	}
	
public void getJosephusPosition(int N,int M)
{
	ListNode p=new ListNode();
	p.setData(1);
	ListNode q=new ListNode();
	q=p;
	for(int i=2;i<=N;i++)
	{
	p.setNext(new ListNode());
	p=p.getNext();
	p.setData(i);
	}
	p.setNext(q);
	for(int count=N;count>1;--count)
	{
		for(int i=1;i<=M-1;++i)
		{
			p=p.getNext();
		}
		System.out.println("Killed "+p.getNext().getData());
		p.setNext(p.getNext().getNext());
	}
	System.out.println("Position Josephus "+p.getData());
}

public ListNode findIntersect(ListNode list1,ListNode list2)
{
	int l1=0;
	int l2=0;
	int diff=0;
	ListNode head1=list1;
	ListNode head2=list2;
	while(head1!=null)
	{
	l1=l1+1;
	head1=head1.getNext();
	}
	while(head2!=null)
	{
	l2=l2+1;
	head2=head2.getNext();
	}
	if(l1<l2)
	{
		head1=list2;
		head2=list1;
		diff=l2-l1;
	}
	if(l2<l1)
	{
		head1=list1;
		head2=list2;
		diff=l1-l2;
	}
	for(int i=0;i<diff;i++)
	{
	head1=head1.getNext();
	}
	while(head1!=null&&head2!=null)
	{
		if(head1==head2)
			return head1;
		head1=head1.getNext();
		head2=head2.getNext();
	}
	return null;
}

public void deleteNodeAccess(ListNode a){
	if(a.next==null||a==null)
		return;
	a.data=a.next.data;
	a.next=a.next.next;
}



public ListNode sumDigits(ListNode a,ListNode b,int carry){
	if(a==null&&b==null)
		return null;
	ListNode ret=new ListNode();
	ret.data=carry;
	int value=carry;
	if(a!=null){
		value+=a.data;
	}
	if(b!=null){
		value+=b.data;
	}
	ret.data=value%10;
	ListNode finret = sumDigits(a==null?null:a.next,
								b==null?null:b.next,
								value>10?1:0);
	ret.setNext(finret);
	return ret;
	}
	
}

