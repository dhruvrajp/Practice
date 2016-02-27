package bstree;

public class BSTNode {
public int data;
public BSTNode Left;
public BSTNode Right;
BSTNode(int data)
{
this.data=data;	
}
public BSTNode() {
	// TODO Auto-generated constructor stub
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public BSTNode getLeft() {
	return Left;
}
public void setLeft(BSTNode left) {
	Left = left;
}
public BSTNode getRight() {
	return Right;
}
public void setRight(BSTNode right) {
	Right = right;
}

}
