package ccupamaz;

import linkedlist.ListNode;

public class LinkedListPalind {
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
	
	public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
        return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=slow.next;
        ListNode temp=null,prev=null;
        while(slow!=null){
            temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        while(prev!=null){
            if(prev.data!=head.data)
                return false;
            prev=prev.next;
            head=head.next;
        }
        return true;
    } 
}
