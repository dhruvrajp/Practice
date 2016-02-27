package ctcode;

public class LinkedList {
public static void main(String[] args){

	Node n=new Node(5);
	Node n1=new Node(6);
	Node n2=new Node(7);
	Node n3=new Node(8);
	Node n4=new Node(6);
	Node n5=new Node(7);
	Node n6=new Node(8);
	Node n7=new Node(9);
	n.next=n1;
	n1.next=n2;
	n2.next=n3;
	n3.next=n4;
	n4.next=n5;
	n5.next=n6;
	n6.next=n7;
	Node shead=n;
	Node fhead=n;
	int i=0,j=0;
	while(j-i!=2){
		if(fhead.next!=null){
		fhead=fhead.next;
		j++;
		}
	}
	while(fhead.next!=null){
		shead=shead.next;
		fhead=fhead.next;
		i++;
		j++;
	}
	System.out.println(shead.data);
	}
}	

class Node{
Node next;
int data;
Node(int data)
{
	this.data=data;
}		
}