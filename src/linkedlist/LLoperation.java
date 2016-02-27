package linkedlist;

public class LLoperation {
	public static void main(String[] args)
	{	
		
		ListNode l1=new ListNode();
		l1.data=5;
		LinkedList ll1=new LinkedList(l1);
		ListNode l2=new ListNode();
		l2.data=6;
		ListNode l3=new ListNode();
		l3.data=7;
		ListNode l4=new ListNode();
		l4.data=8;
		ListNode l5=new ListNode();
		l5.setData(9);
		ListNode l6=new ListNode();
		l6.setData(30);
		ll1.insert(l1,l2,1);
		ll1.insert(l2,l3,2);
		ll1.insert(l2,l4,3);
		ll1.insert(l2,l5,3);
		ll1.search(l2,9);
		ll1.traverse(l2);
		ll1.deleteNodeAccess(l3);
		System.out.println("After Delete ");
		ll1.traverse(l2);
		System.out.println("Reversal ");
		ListNode head=ll1.reversal(l2);
		ll1.insert(head, l6, 3);
		ll1.traverse(head);
		ll1.midpoint(head);
		ll1.revinpair(head);
		ll1.getJosephusPosition(10, 3);
		ListNode headsort=new ListNode();
		headsort.setData(14);
		ListNode ls1=new ListNode();
		ls1.setData(45);
		ListNode ls2=new ListNode();
		ls2.setData(5);
		ListNode ls3=new ListNode();
		ls3.setData(15);
		ListNode ls4=new ListNode();
		ls4.setData(4);
		headsort.setNext(ls1);
		ls1.setNext(ls2);
		ls2.setNext(ls3);
		ls3.setNext(ls4);
		ListNode hsn=sortMerge(headsort);
		LinkedList lsort=new LinkedList(hsn);
		lsort.traverse(hsn);
		
	}

	private static ListNode sortMerge(ListNode headnode) {
		if(headnode==null||headnode.getNext()==null)
				return headnode;
		ListNode mainhead=headnode;
		ListNode left=mainhead;
		LinkedList temp= new LinkedList(mainhead);
		ListNode middle=temp.midpoint(mainhead);
		ListNode right=middle.getNext();
		middle.setNext(null);
		return merge(sortMerge(left),sortMerge(right));

	}

	private static ListNode merge(ListNode sortMerge, ListNode sortMerge2) {
		ListNode fakeHead=new ListNode();
		ListNode newHead=fakeHead;
		while(sortMerge!=null&&sortMerge2!=null)
		{
			if(sortMerge.getData()<sortMerge2.getData())
			{
				newHead.setNext(sortMerge);
				sortMerge=sortMerge.getNext();
			}
			else
			{
				newHead.setNext(sortMerge2);
				sortMerge2=sortMerge2.getNext();	
			}
			newHead=newHead.getNext();
		}
		while(sortMerge!=null)
		{
		newHead.setNext(sortMerge);
		sortMerge=sortMerge.getNext();
		newHead=newHead.next;
		}
		while(sortMerge2!=null)
		{
		newHead.setNext(sortMerge2);
		sortMerge2=sortMerge2.getNext();
		newHead=newHead.next;
		}
		return fakeHead.getNext();
	}
	
}
