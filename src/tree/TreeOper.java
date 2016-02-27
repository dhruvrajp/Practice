package tree;

import java.util.LinkedList;
import java.util.Queue;

import bstree.BSTNode;

public class TreeOper {
public static void main(String[] args)
{
Tree tr=new Tree();
BTreeNode btrn=new BTreeNode();
BTreeNode btrnl=new BTreeNode();
BTreeNode btrnr=new BTreeNode();
BTreeNode btrnl1=new BTreeNode();
BTreeNode btrnr1=new BTreeNode();
BTreeNode btrnl2=new BTreeNode();
BTreeNode btrnr2=new BTreeNode();
BTreeNode extra=new BTreeNode();
BTreeNode extra1=new BTreeNode();
extra.setData(15);
extra1.setData(100);
btrn.setData(10);
btrnl.setData(12);
btrnr.setData(14);
btrnl1.setData(11);
btrnr1.setData(16);
btrnl2.setData(5);
btrnr2.setData(6);
btrn.setLeft(btrnl);
btrn.setRight(btrnr);
btrnl.setLeft(btrnl1);
btrnl.setRight(btrnr1);
btrnr.setLeft(btrnl2);
btrnr.setRight(btrnr2);
btrnr2.setLeft(extra1);
btrnr2.setRight(extra);
tr.diagonalPrint(btrn);
System.out.println("Inorder");
tr.inorder(btrn);
System.out.println("\n"+"Preorder"+"\n");
tr.preorder(btrn);
System.out.println("\n"+"Postorder"+"\n");
tr.postorder(btrn);
System.out.println("\n"+"Max "+tr.findMax(btrn));
System.out.println("\n"+"Reversal");
tr.revprint(btrn);
System.out.println("\n"+"Count"+tr.leafcount(btrn));
Tree trnew=new Tree();
BTreeNode btrnew=new BTreeNode();
BTreeNode btrnewl=new BTreeNode();
BTreeNode btrnewr=new BTreeNode();
BTreeNode btrnewl1=new BTreeNode();
BTreeNode btrnewr1=new BTreeNode();
BTreeNode btrnewl4=new BTreeNode();
btrnew.setData(10);
btrnewl.setData(5);
btrnewr.setData(15);
btrnewl1.setData(12);
btrnewr1.setData(14);
btrnewl4.setData(2);
btrnew.setLeft(btrnewl);
btrnew.setRight(btrnewr);
btrnewl.setLeft(btrnewl1);
btrnewl.setRight(btrnewr1);
btrnewr.setLeft(btrnewl4);
countSingle(btrnew);
int levmulti=multiAddLeaves(btrnew);
System.out.println("\n"+levmulti+"Answer");
}

private static void countSingle(BTreeNode btrnew) {
//NEEED TO DECLARE COUNT CLASS HERE
	Count c=new Count();
	countSingleTree(btrnew,c);
	System.out.println("Single Tree Count " +c.count);
	
}

private static boolean countSingleTree(BTreeNode btrnew,Count c) {
	boolean left=false;
	boolean right=false;
	if(btrnew==null)
		return true;
	
	left=countSingleTree(btrnew.getLeft(),c);
	right=countSingleTree(btrnew.getRight(),c);
	if(left==false||right==false)
		return false;
	if(btrnew.getLeft()!=null&&btrnew.getData()!=btrnew.getLeft().getData())
	{
		return false;
	}
	if(btrnew.getRight()!=null&&btrnew.getData()!=btrnew.getRight().getData())
	{
		return false;
	}
	c.count++;
	return true;
}

private static int multiAddLeaves(BTreeNode btrnew) {
	Queue<BTreeNode> q1=new LinkedList<BTreeNode>();
	q1.add(btrnew);
	q1.add(null);
	int levmulti=1;
	int levadd=1;
	while(!q1.isEmpty())
	{	
	BTreeNode temp=q1.poll();
	if(temp==null)
	{
	if(levadd!=0)
	{
	levmulti*=levadd;
	levadd=0;
	}
	if(!q1.isEmpty())
		q1.add(null);
	}
	else
	{
		if(temp.getLeft()!=null)
			q1.add(temp.getLeft());
		if(temp.getRight()!=null)
			q1.add(temp.getRight());
		if(temp.getLeft()==null&&temp.getRight()==null)
		{
			levadd=levadd+temp.getData();
		}
	}	
	}
	return levmulti;
	
}

static BSTNode prev;
static int minDiff=Integer.MAX_VALUE;
private static void findMin(BSTNode root){
	if(root!=null){
		findMin(root.Left);
		if(prev!=null&&minDiff>root.data-prev.data){
			minDiff=root.data-prev.data;
		}
		prev=root;
		findMin(root.Right);
	}
}

public boolean isValidSerialization(String preorder) {
        if(preorder==null){
        return false;
        }
        if(preorder.length()==1&&preorder.charAt(0)=='#')return true;
        int count=0;
        for(int i=0;i<preorder.length();i++){
            if(preorder.charAt(i)==',')
                continue;
            else if(preorder.charAt(i)=='#')
                count--;
            else if(i==0||preorder.charAt(i-1)==','){
                count+=(i==0?2:1);
            }
            if(count<0||(count==0&&i!=preorder.length()))
            return false;
        }
        return (count==0);
    }


	
}
