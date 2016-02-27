package ctcode;

import java.util.LinkedList;
import java.util.*;
public class CTCTreeOper{
	public static void main(String[] args){
		BSTNode broot=new BSTNode(45);
		BSTree btree=new BSTree(broot);
		btree.addData(broot,50);
		btree.addData(broot,30);
		btree.addData(broot,35);
		btree.addData(broot,48);
		btree.addData(broot,65);
		btree.addData(broot,20);
		btree.inTraverse(broot);
		BSTNode broot2=new BSTNode(30);
		BSTree btree2=new BSTree(broot);
		btree2.addData(broot2,35);
		btree2.addData(broot2,20);
		System.out.println("\n"+"Check point " +checkSubTree(broot,broot2));
		System.out.println("\n"+btree.checkBalance(broot));
		int[] arr={10,20,30,40,50,60,70,80};
		createMinTree(arr);
		int[] arr2={1,4,7,6,3,13,14,10,8};
		List<LinkedList<BSTNode>> larr=createLinkedLists(broot);
		int i=0;
		for(LinkedList<BSTNode> l:larr){
			i++;
			System.out.println("\n");
			for(BSTNode b:l){
				System.out.print(" "+b.data);
			}	
		}
		BSTNode anc=findLCA(broot,20,35);
		System.out.println("\n"+anc.data);
		int[] arra={10,20,25,45,30,40,50};
		sumPath(broot,95);
//		System.out.println(subCheck(createMinTree(arra),createMinTree(arrb)));
	}


	static BSTNode inorderSucc(BSTNode node){
		BSTNode p;
		if (node==null) return node;
		if(node.parent==null||node.right!=null){
			p=leftMost(node.right);
		}else{
			while((p=node.parent)!=null){
				if(p.left==node)
					break;
				node=p;
			}
		return p;	
		}
		return null;
	}
	
	
	private static BSTNode leftMost(BSTNode right) {
		if(right==null) return null;
		while(right.left!=null){
			right=right.left;
		}
		return right;
	}


	private static boolean checkSubTree(BSTNode broot, BSTNode broot2) {
			if(broot==null)
				return false;
			if(broot.data==broot2.data){
				return match(broot,broot2);
			}else{
				if(checkSubTree(broot.left,broot2)||
				   checkSubTree(broot.right,broot2)){
					return true;
				}
			}
			return false;
	}


	private static boolean match(BSTNode broot, BSTNode broot2) {
		if(broot==null&&broot2==null)
			return true;
		if(broot==null||broot2==null)
			return false;
		if(broot.data!=broot2.data)
			return false;
		if(match(broot.left, broot2.left)&&match(broot.right,broot2.right))
			return true;
		return false;
	}


	private static void sumPath(BSTNode broot, int sum) {
		ArrayList<BSTNode> al=new ArrayList<BSTNode>();
		int level=0;
		sumPathUtil(broot,sum,al,level);
	}


	private static void sumPathUtil(BSTNode broot, int sum, ArrayList<BSTNode> al, int level) {
		if(broot==null)return;
		int tmp=sum;
		al.add(broot);
		for(int i=level;i>-1;i--){
			tmp-=al.get(i).data;
			if(tmp==0){
				printPath(al,i,level);
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<BSTNode> acl1=(ArrayList<BSTNode>) al.clone();
		@SuppressWarnings("unchecked")
		ArrayList<BSTNode> acl2=(ArrayList<BSTNode>) al.clone();
		sumPathUtil(broot.left,sum,acl1,level+1);
		sumPathUtil(broot.right,sum,acl2,level+1);
	}
	private static void printPath(ArrayList<BSTNode> al, int i, int level) {
		for(int j=i;j<=level;j++){
			System.out.print("-> " +al.get(j).data);
		}
		System.out.println("\n");
	}


	private static BSTNode findLCA(BSTNode broot, int i, int j) {
		if(broot.data==i||broot.data==j){
			return broot;
		}
		BSTNode left=null,right=null;
		if(broot.left!=null){
		left=findLCA(broot.left,i,j);
		}
		if(broot.right!=null){
		right=findLCA(broot.right,i,j);
		}
		if((left!=null)&&(right!=null)){
		return broot;
		}
		else {
			if(left!=null)
				return left;
			if(right!=null)
				return right;
		}
		return null;
	}

	private static List createLinkedLists(BSTNode broot) {
		Queue<BSTNode> q1=new LinkedList<BSTNode>();
		List<LinkedList<BSTNode>> al=new ArrayList<LinkedList<BSTNode>>();
		q1.add(broot);
		q1.add(null);
		int i=0;
		while(!q1.isEmpty()){
			BSTNode curr=q1.poll();
			if(curr!=null){
				if(curr.left!=null){
					q1.add(curr.left);
				}	
				if(curr.right!=null){
					q1.add(curr.right);
				}
				if(i>=al.size()){
					LinkedList<BSTNode> l=new LinkedList<BSTNode>();
					l.add(curr);
					al.add(l);
				}else{
					LinkedList<BSTNode> l=al.get(i);
					l.add(curr);
				}
			}else {
				if(!q1.isEmpty())
				{
					q1.add(null);
					i++;
				}
			}
			
		}
		return al;
	}


	static BSTNode createMinTree(int[] arr){
		
		BSTNode newroot=createMinTreeUtil(arr,0,arr.length-1);
		BSTree minTree=new BSTree(newroot);
		minTree.inTraverse(newroot);
		return newroot;
	
	}


	private static BSTNode createMinTreeUtil(int[] arr, int i, int length) {
		if(length>i)
		{
			int mid=(length-i)/2+i;
			BSTNode root=new BSTNode(arr[mid]);
			root.left=createMinTreeUtil(arr,i,mid);
			root.right=createMinTreeUtil(arr,mid+1,length);
			return root;
		}
		return null;
		
	}
}


class BSTree {

BSTNode root;
int size;
BSTree(BSTNode root)
{
	this.root=root;
	int size=0;
}
public BSTNode addData(BSTNode root,int d) {
	if(root==null){
		root=new BSTNode(d);
		root.left=null;
		root.right=null;
		size++;
	}
	else if(root.data<d) {
		root.right=addData(root.right,d);
		size++;
	}
	else if(root.data>=d){
		root.left=addData(root.left,d);
		size++;
	}
	return root;
}

public void inTraverse(BSTNode root){
	if(root==null){
		return;
	}
	inTraverse(root.left);
	System.out.print(" "+root.data);
	inTraverse(root.right);
}

public boolean checkBalance(BSTNode root){
	if(root.left==null&&root.right==null)
		return true;
	else if(root.left!=null&&root.right==null){
		return false;
	}
	else if(root.right!=null&&root.left==null){
		return false;
	}
	if(checkBalance(root.left)==true&&checkBalance(root.right)==true){
		return true;
	}
	else return false;
}

}
