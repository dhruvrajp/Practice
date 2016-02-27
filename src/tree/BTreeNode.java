package tree;

public class BTreeNode {
BTreeNode left;
BTreeNode right;
int data;


BTreeNode(){}
BTreeNode(int data){
	this.data=data;
}

public BTreeNode getLeft() {
	return left;
}
public void setLeft(BTreeNode left) {
	this.left = left;
}
public BTreeNode getRight() {
	return right;
}
public void setRight(BTreeNode right) {
	this.right = right;
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
	
}
