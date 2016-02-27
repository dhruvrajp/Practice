package bstree;

import java.util.Iterator;
import java.util.LinkedList;

public class BSToper {

	public static void main(String[] args){
	BSTNode root=new BSTNode(4);
	bstree.BST bstree=new BST();
	bstree.insert(root, 4);
	bstree.insert(root, 8);
	bstree.insert(root, 2);
	bstree.insert(root, 6);
	bstree.insert(root, 11);
	bstree.insert(root, 7);
	bstree.insert(root, 5);
	bstree.insert(root, 1);
	bstree.insert(root, 3);
	bstree.find(root, 7);
//	bstree.delete(root,8);
//	System.out.println("\n"+"After Delete "+"\n");
	bstree.find(root, 6);
	BSTNode max=bstree.findMax(root);
	BSTNode min=bstree.findMin(root);
	System.out.println("Max "+max.getData()+"Min "+min.getData());
	BSTNode head=bstree.BST2DLL(root);
	System.out.println("Check "+"\n");
	int datahead=head.getData();
	while(head.getRight().data!=datahead)
	{
	System.out.print(" "+head.getData());
	head=head.getRight();
	}	
	int[] array={100,200,300,400,500,600,700,800};
	BSTNode newroot=bstree.buildBST(array,0, array.length-1);
	System.out.println("\n");
	bstree.inorder(newroot);
	System.out.println("\n"+"Pre order");
	bstree.preorder(newroot);
	System.out.println("\n"+"Single Linked List to BST");
	LinkedList<Integer> ll=new LinkedList<Integer>();
	Iterator<Integer> it=ll.iterator();
	ll.add(10);
	ll.add(20);
	ll.add(25);
	ll.add(30);
	ll.add(40);
	ll.add(50);
	ll.add(60);
//	BSTNode convert=bstree.llistToBST(ll, 0, ll.size()-1);
//	System.out.println(convert.getData());
//	bstree.preorder(convert);
	BSTNode final1=bstree.listToBSTfinal(ll.iterator(), 0, ll.size()-1);
	bstree.preorder(final1);
	bstree.rangePrinter(final1, 30, 60);
	BSTNode small=bstree.floor(final1, 26);
	System.out.println("SMall "+small.getData());
	bstree.nonRecPost(final1);
	BSTNode node=bstree.kthSmallest(final1, 6);
	System.out.println(" "+node.getData());
	}
	
	
}
