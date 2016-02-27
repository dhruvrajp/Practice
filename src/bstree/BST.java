package bstree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BST {
	
public void inorder(BSTNode root)
{
if (root==null)
	return;
else
{
	inorder(root.getLeft());
	System.out.print(" "+root.getData());
	inorder(root.getRight());

}	
}

public void preorder(BSTNode root)
{
	if (root==null)
		return;
	else
	{
		System.out.println(" "+root.getData());
		preorder(root.getLeft());
		preorder(root.getRight());

	}	
}
	
public BSTNode insert(BSTNode root,int data)
{
	if(root==null)
	{
		root=new BSTNode(data);
		root.setLeft(null);
		root.setRight(null);
	}
	else
	{
		if(data<root.getData())
		{
			root.setLeft(insert(root.getLeft(), data));
		}
		else if(data>root.getData())
		{
			root.setRight(insert(root.getRight(),data));
		}
	}
return root;
}
	
//NonRec
public void nonRecIn(BSTNode root)
{
if(root==null)return;
Stack<BSTNode> st=new Stack<BSTNode>();
while(true)
{
while(root!=null)
{
	st.push(root);
	root=root.getLeft();
}
if(st.isEmpty())
{
	break;
}
	root=st.pop();
	System.out.print(" "+root.getData());
	root=root.getRight();
}
}

//NonRecPOst
public void nonRecPost(BSTNode root)
{
if(root==null)
	return;
Stack<BSTNode> st=new Stack<BSTNode>();
while(true)
{
	while(root!=null)
	{
		if(root.getRight()!=null)
		{st.push(root.getRight());}
		st.push(root);
		root=root.getLeft();
	}
	if(st.isEmpty())
		return;
	else
	{
		root=st.pop();
		if(!st.isEmpty()&&root.getRight()!=null&&root.getRight()==st.peek())
		{
			st.pop();
			st.push(root);
			root=root.getRight();
		}
		else
		{
			System.out.println(root.getData());
			root=null;
		}
	}
}
}

	
public void find(BSTNode root,int data)
{
	if(root==null)
		return;
	if(data==root.getData())
	{
		System.out.print("->"+root.getData());
		return;
	}
	else if(data<root.getData())
	{	
			System.out.print("->"+root.getData());
			find(root.getLeft(),data);
	}
	else
	{
			System.out.print("->"+root.getData());
			find(root.getRight(),data);
	}
	
}

public BSTNode findMax(BSTNode root)
{
if(root==null)
	return null;
else
	if(root.getRight()==null) 
		return root;
	else
	return findMax(root.getRight());
	
}

public BSTNode findMin(BSTNode root)
{
if(root==null)
	return null;
else
	if(root.getLeft()==null) 
		return root;
	else
	return findMin(root.getLeft());
	
}

public BSTNode delete(BSTNode root,int data)
{
	BSTNode temp;
	if(root==null)
		return null;
	else
	if(data<root.getData())
		root.Left=delete(root.getLeft(),data);
	else if(data>root.getData())
		root.Right=delete(root.getRight(),data);
		
	else
	{
		if(root.getLeft()!=null&&root.getRight()!=null)
		{
			temp=findMax(root.getLeft());
			root.setData(temp.getData());
			root.Left=delete(root.getLeft(),root.getData());
		}
		else
		{
			temp=root;
			if(root.getLeft()==null)
				root=root.getRight();
			if(root.getRight()==null)
				root=root.getLeft();
			if(root.getLeft()==null&root.getRight()==null)
			{
				return null;
			}
		}
	}
	return root;
}

public int findLCA(BSTNode root,int a,int b)
{
	while(true)
	{
	if(a<root.getData()&&b>root.getData()||a>root.getData()&&b<root.getData())
		return root.getData();
	else
		if(a<root.getData())
			root=root.getLeft();
		else
			root=root.getRight();
	}
}

public boolean isBST(BSTNode root,int min,int max)
{
if (root==null)
	return true;
else
//Recursive call to left and right tree with change in min and max values.	
	return(root.getData()>min&&root.getData()<max&&isBST(root.getLeft(),min,root.getData())
			&&isBST(root.getRight(),root.getData(),max));

}
// http://stackoverflow.com/questions/9573738/converting-an-ordered-binary-tree-to-a-doubly-circular-link-list
public BSTNode BST2DLL(BSTNode root)
{	
if(root==null)
	return root;
else
{
BSTNode leftTree=BST2DLL(root.getLeft());
BSTNode rightTree=BST2DLL(root.getRight());
BSTNode head;
if(leftTree==null)
{
//If LeftTree is null then current node is the root
	head=root;	
}
else
{
	head=leftTree;
	//THe previous node of head node will point to the last node traversed;
	leftTree.getLeft().setRight(root);
	//leftTree.getLeft() is the last node traversed
	root.setLeft(leftTree.getLeft());
}
if(rightTree==null)
{
	head.setLeft(root);
	root.setRight(head);
}
else
{
	//
	head.setLeft(rightTree.getLeft());
	rightTree.getLeft().setRight(head);
	rightTree.setLeft(root);
	root.setRight(rightTree);
}
	return head;	
}
}
//Last method with final keyword in name is final method
public BSTNode buildBST(int[] A,int left,int right)
{
BSTNode node=new BSTNode();
if(left>right)
	return null;
if(left==right)
{
	node.setData(A[left]);;
	node.setLeft(null);
	node.setRight(null);
}
else
{
	int mid=(left+right)/2;
	node.setData(A[mid]);
	node.setLeft(buildBST(A,left,mid-1));
	node.setRight(buildBST(A,mid+1,right));
}
return node;
}

public BSTNode llistToBST(LinkedList<Integer> ll, int start, int end) {
	if(start>end)
		return null;
	int mid=start+(end-start)/2;
	BSTNode leftchild=llistToBST(ll,start,mid-1);
	BSTNode parent=new BSTNode();
	parent.setData(ll.getFirst());
	parent.setLeft(leftchild);
	ll.poll();
	parent.setRight(llistToBST(ll,mid+1,end));
	return parent;
}

public BSTNode listToBSTfinal(Iterator<Integer> it,int start,int end)
{	BSTNode next=new BSTNode();
	if(start>end)
		return null;
	else
	{
		int mid=start+(end-start)/2;
		next.setLeft(listToBSTfinal(it,start,mid-1));
		next.setData(it.next());
		next.setRight(listToBSTfinal(it,mid+1,end));
		return next;
	}	
		
}

public void rangePrinter(BSTNode root,int k1,int k2)
{
if(root==null)
	return;
if(root.getData()>=k1)
	rangePrinter(root.getLeft(),k1,k2);
if(root.getData()>=k1&&root.getData()<=k2)
	System.out.println(root.getData());
if(root.getData()<=k1)
	rangePrinter(root.getRight(),k1,k2);
}

//http://algs4.cs.princeton.edu/lectures/32BinarySearchTrees.pdf 
//Here if root is bigger than given data scan left subtree then scan right subtree of leftsubtree roots
public BSTNode floor(BSTNode root,int data)
{
	if(root==null)
		return null;
	if(root.data==data)
		return root;
	if(root.data>data)
		return floor(root.getLeft(),data);
	BSTNode t=floor(root.getRight(),data);
	if(t!=null) return t;
	else return root;
}

//http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
public BSTNode kthSmallest(BSTNode root,int k)
{
Stack<BSTNode> st=new Stack<BSTNode>();
int count=0;
while(root!=null)
{
	st.push(root);
	root=root.getLeft();
}
while(!st.isEmpty())
{
root=st.pop();	
count=count+1;
if(count==k)
	return root;
if(root.getRight()!=null)
{
root=root.getRight();
while(root!=null)
{
st.push(root);
root=root.getLeft();
}
}
}	
return null;
}

} 