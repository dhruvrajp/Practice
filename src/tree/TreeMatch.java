package tree;

public class TreeMatch {
public static void main(String[] args)
{
	Tree tr=new Tree();
	BTreeNode btrn=new BTreeNode();
	BTreeNode btrnl=new BTreeNode();
	BTreeNode btrnr=new BTreeNode();
	BTreeNode btrnl1=new BTreeNode();
	BTreeNode btrnr1=new BTreeNode();
//Tree two
	BTreeNode btrn2=new BTreeNode();
	BTreeNode btrn2l=new BTreeNode();
	BTreeNode btrn2r=new BTreeNode();
	BTreeNode btrn2l1=new BTreeNode();
	BTreeNode btrn2r1=new BTreeNode();
	btrn.setData(10);
	btrnl.setData(11);
	btrnr.setData(14);
	btrn2.setData(50);
	btrn2l.setData(101);
	btrn2r.setData(123);
	btrn.setLeft(btrnl);
	btrn.setRight(btrnr);
	btrnl.setLeft(btrn2);                    
	btrn2.setLeft(btrn2l);
	btrn2.setRight(btrn2r);
	Tree tm=new Tree();
	System.out.println("Inorder");
	tm.inorder(btrn);
	System.out.println("ZigZag");
	tm.zigzag(btrn);
}
}
