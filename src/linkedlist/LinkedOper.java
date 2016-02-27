package linkedlist;

public class LinkedOper {
public static void main(String[] args){
	ListNode l1=new ListNode();
	l1.data=5;
	ListNode l2=new ListNode();
	l2.data=6;
	ListNode l3=new ListNode();
	l3.data=7;
	ListNode l4=new ListNode();
	l4.data=8;
	ListNode l5=new ListNode();
	l5.data=9;
	
	LinkedList ll1=new LinkedList(l1);
	l1.setNext(l2);
	l2.setNext(l3);
	l3.setNext(l4);
	l4.setNext(l5);
	l5.setNext(l3);
	
/*	ListNode ret=ll1.sumDigits(l1, l4,0);
	while(ret!=null){
		System.out.println(ret.data);
		ret=ret.getNext();
	}*/
	System.out.println("Loop start "+checkLoop(l1).data);
}

private static ListNode checkLoop(ListNode l1) {
	if(l1==null)
		return null;
	ListNode slwPtr=l1;
	ListNode fastPtr=l1;
	while(slwPtr!=null&&fastPtr.getNext()!=null){
		slwPtr=slwPtr.getNext();
		fastPtr=fastPtr.getNext().getNext();
		if(slwPtr.data==fastPtr.data)
			break;
	}
	slwPtr=l1;
	while(slwPtr.data!=fastPtr.data){
		slwPtr=slwPtr.getNext();
		fastPtr=fastPtr.getNext();
	}
	
	return slwPtr;
}
}
