package tree;

public class TreeMirror {
public static void main(String[] args)
{
	BTreeNode root=new BTreeNode();
	root.setData(10);
	BTreeNode left=new BTreeNode();
	left.setData(12);
	BTreeNode right=new BTreeNode();
	right.setData(15);
	BTreeNode leftr=new BTreeNode();
	leftr.setData(16);
	root.setLeft(left);
	root.setRight(right);
	left.setRight(leftr);
	BTreeNode root2=new BTreeNode();
	root2.setData(10);
	BTreeNode left2=new BTreeNode();
	left2.setData(12);
	BTreeNode right2=new BTreeNode();
	right2.setData(15);
	BTreeNode leftr2=new BTreeNode();
	leftr2.setData(16);
	BTreeNode check=new BTreeNode();
	check.setData(90);
	root2.setRight(left2);
	root2.setLeft(right2);
	left2.setLeft(leftr2);
	leftr2.setLeft(check);
	System.out.println("Mirror "+new Tree().TreeMirror(root, root2));
	Tree t1=new Tree();
	t1.path(root2, 90);
}
}
