package dll;

public class DLL {
	public void traverse(DLLNode headnode)
	{
		DLLNode current=headnode;
		while(current!=null)
		{
			System.out.println("Node data "+current.getData());
			current=current.getNext();
		}
			
	}
	
	public DLLNode insert(DLLNode headnode,DLLNode insert,int position)
	{
		if(headnode==null)
			return insert;
		int size=length(headnode);
		if(position<1||position>size+1)
		{
			System.out.println("Invalid len "+size);
			return headnode;
		}
		if(position==1)
			{
				insert.setNext(headnode);
				insert.setPrev(null);
				headnode.setPrev(insert);
				return insert;
			}
			else
			{
				DLLNode current=headnode;
				int count=1;
				while(count<position-1)
				{
					current=current.getNext();
					count++;
				}
				DLLNode next=current.getNext();
				insert.setPrev(current);
				insert.setNext(next);
				if(next!=null)
				next.setPrev(current);
				current.setNext(insert);
			}
		return headnode;		
	}
	
	public DLLNode delete(DLLNode headnode,DLLNode delete,int position)
	{
		if(headnode==null)
			return delete;
		int size=length(headnode);
		if(position<1||position>size+1)
		{
			System.out.println("Invalid len"+size);
			return headnode;
		}
		if(position==1)
			{
				DLLNode current=headnode.getNext();
				current.setPrev(null);
				headnode=current;
				return delete;
			}
			else
			{
				DLLNode previous=headnode;
				int count=1;
				while(count<position-1)
				{
					previous=previous.getNext();
					count++;
				}
				DLLNode todelete=previous.getNext();
				DLLNode next=todelete.getNext();
				previous.setNext(next);
				if(next!=null)
					next.setPrev(previous);
			}
		return headnode;		
	}

	private int length(DLLNode headnode) {
		int count=0;
		DLLNode current=headnode;
		while(current!=null)
		{
		count++;
		current=current.getNext();	
		}
		return count;
	}
	
	public DLLNode midPoint(DLLNode head)
	{
	DLLNode ptr1=head;
	DLLNode ptr2=head;
	int i=0;
	if(head==null)
		return head;
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
	return ptr2;
	}
	
	public DLLNode dllToBST(DLLNode head)
	{
		DLLNode temp,p,q;
		if(head==null||head.getNext()==null)
		return head;
		temp=midPoint(head);
		p=head;
		if(p==temp)
		{
			temp=temp.getNext();
		}
		else
		{
			while(p.getNext()!=temp)
			p=p.getNext();
		}
		p.setNext(null);
		q=temp.getNext();
		temp.setNext(null);
		temp.setPrev(dllToBST(head));
		temp.setNext(dllToBST(q));
		return temp;
	}
	
	
}
