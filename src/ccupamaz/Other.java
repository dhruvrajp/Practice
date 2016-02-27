package ccupamaz;
import java.util.*;
/*This class doesn't have any implementation only methods of questions asked*/
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

public class Other {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode p1=l1;
	        ListNode p2=l2;
	        ListNode fakeHead=new ListNode(0);
	        ListNode p=fakeHead;
	        while(p1!=null&&p2!=null){
	            if(p1.val<p2.val){
	                p.next=p1;
	                p1=p1.next;
	            }else{
	                p.next=p2;
	                p2=p2.next;
	            }
	            p=p.next;
	        }
	        if(p1!=null){
	            p.next=p1;
	        }
	        if(p2!=null){
	            p.next=p2;
	        }
	        
	        return fakeHead.next;
	    }
	 
	 
	 static void print(int[] a){
		 int max=Integer.MIN_VALUE;
		 for(int i:a){
			 if(i>max){
				 max=i;
			 }
		 }
		 for(int i=0;i<max;i++){
			 for(int j=0;j<a.length;j++){
				 if(max-a[i]<=a[j]){
					 System.out.println('#');
				 }else{
					 System.out.println(' ');
				 }
			 }
		 }
	 }
	 
	 
	 
}
