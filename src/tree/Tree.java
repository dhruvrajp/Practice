package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class Tree {

public void inorder(BTreeNode node)
{
	if(node!=null)
	{
	inorder(node.getLeft());
	System.out.print(node.getData()+" ");	
	inorder(node.getRight());
	}
}
public void preorder(BTreeNode node)
{
	if(node!=null)
	{
	System.out.print(node.getData()+" ");
	preorder(node.getLeft());
	preorder(node.getRight());		
	}
}
public void postorder(BTreeNode node)
{
	if(node!=null)
	{
	postorder(node.getLeft());	
	postorder(node.getRight());
	System.out.print(node.getData()+" ");
	}
	
}

public int findMax(BTreeNode node)
{
int max=Integer.MIN_VALUE;
if(node==null)
{
return max;
}
max=node.getData();
int left=findMax(node.getLeft());
int right=findMax(node.getRight());
if(max<left)
{
max=left;	
}
else
if(max<right)
{
max=right;	
}
return max;
}

public int findMaxIterate(BTreeNode node)
{
BTreeNode temp;
int max=Integer.MIN_VALUE;
Queue<BTreeNode> q=new LinkedList<BTreeNode>();
q.add(node); 
while(!q.isEmpty())
{
	temp=q.poll();
	if(max<temp.getData())
		max=temp.getData();
	if(temp.getLeft()!=null)
		q.add(temp.getLeft());
	if(temp.getRight()!=null)
		q.add(temp.getRight());
}
return max;
}

public void revprint(BTreeNode node)
{
Queue<BTreeNode> q1=new LinkedList<BTreeNode>();
Stack<BTreeNode> s1=new Stack<BTreeNode>();
BTreeNode temp;
if(node==null)
{
System.out.println("null");
}
else
{
q1.add(node);
	while(!q1.isEmpty())
	{
	temp=q1.poll();
	if(temp.getRight()!=null)
	{
	q1.add(temp.getRight());	
	}
	if(temp.getLeft()!=null)
	{
	q1.add(temp.getLeft());	
	}
	s1.push(temp);
	}
	while(!s1.isEmpty())
	{
	System.out.print(" "+s1.pop().getData());
	}
}
}
public int leafcount(BTreeNode root)
{
	int total;
	if(root==null)
	return 0;
	else
	{
	if(root.getLeft()==null&&root.getRight()==null)
	{
		return 1;
	}
	int left=leafcount(root.getLeft());
	int right=leafcount(root.getRight());
	total=left+right;
	}	
	return total;
}
public boolean match(BTreeNode root1, BTreeNode root2) 
{
if(root1==null&&root2==null)
{
return true;
}
if(root1==null||root2==null)
{
return false;
}
else
{
	if(root1.getData()==root2.getData())
	{
		if (match(root1.getLeft(),root2.getLeft())==true)
		{
				return match(root1.getRight(),root2.getRight());
		}
	}
	return false;
}	
}

public int diameter(BTreeNode root)
{
	int left=longest(root.getLeft());
	int right=longest(root.getLeft());
	return left+right;
}

public int longest(BTreeNode root)
{
int count=0,leftdia,rightdia;
if(root==null)
	return count;
leftdia=longest(root.getLeft());
rightdia=longest(root.getRight());
return Math.max(leftdia, rightdia)+1;
}
//PLEASE REMEMBER QUEUE DELETES FROMS START IN LEVEL ORDER TRAVERSAL
public int maxlevel(BTreeNode root)
{
int maxlevel=0;
int currsumm=0,maxsum=0;
BTreeNode temp;
Queue<BTreeNode> q1=new LinkedList<BTreeNode>();
if (root==null)
return 0;
else
{
q1.add(root);
q1.add(null);
while(!q1.isEmpty())
{
temp=q1.poll();
if(temp==null)
{
	if(currsumm>maxsum)
	{
		maxsum=currsumm;
		maxlevel++;
	}
	if(!q1.isEmpty())
	{
	q1.add(null);
	currsumm=0;
	}
}
else
{
	currsumm=currsumm+temp.getData();
	if(temp.getLeft()!=null)
	{
		q1.add(temp.getLeft());
	}
	if(temp.getRight()!=null)
	{
		q1.add(temp.getRight());
	}
}
}
}
System.out.println("Sum "+maxsum);
return maxlevel;
	
}
public boolean TreeMirror(BTreeNode node1, BTreeNode node2)
{
	if(node1==null&&node2==null)
	return true;
	else
	if(node1==null||node2==null)
		return false;
	else
	{
	if (node1.getData()==node2.getData())
			{
			if (TreeMirror(node1.getLeft(),node2.getRight())==true)
			{
				return TreeMirror(node1.getRight(),node2.getLeft());
			}
			else
			{
				return false;
			}
			}
	else
	{
		return false;
	}
	}
}

public int path(BTreeNode root,int data)
{
	if(root==null)
		return 0;
	else
	{
		if(root.getData()==data)
		{
			System.out.println(root.getData());
			return 1;
		}
		else
		{
			if(path(root.getLeft(),data)==1)
			{
				System.out.println(root.getData());
				return 1;
			}
			else if(path(root.getRight(),data)==1)
			{
				System.out.println(root.getData());
				return 1;
			}
			return 0;
		}

		
	}
	
}

public void zigzag(BTreeNode root)
{
BTreeNode temp;
int leftoright=1;
if(root==null)
{
	return;
}
Stack<BTreeNode> currentLevel=new Stack<BTreeNode>();
Stack<BTreeNode> nextLevel=new Stack<BTreeNode>();
currentLevel.push(root);
while(!currentLevel.isEmpty())
{
	temp=currentLevel.pop();
	if(temp!=null)
	{
	System.out.println(temp.getData());
	if(leftoright==1)
	{
		if(temp.getRight()!=null)
		{
			nextLevel.push(temp.getRight());
		}
		if(temp.getLeft()!=null)
		{
			nextLevel.push(temp.getLeft());
		}
	}
	else
	{
		if(temp.getLeft()!=null)
		{
			nextLevel.push(temp.getLeft());
		}
		if(temp.getRight()!=null)
		{
			nextLevel.push(temp.getRight());
		}		
	}
  }
	if(currentLevel.isEmpty())
	{
		while(nextLevel.isEmpty()!=true)
		{
			currentLevel.push(nextLevel.pop());
		}
		leftoright=1-leftoright;
	}	

}

}

public void diagonalPrint(BTreeNode root){
	Queue<BTreeNode> q1=new LinkedList<BTreeNode>();
	HashMap<Integer,LinkedList<BTreeNode>> hmp=new HashMap<Integer,LinkedList<BTreeNode>>();
	int lev=0;
	q1.add(root);
	hmp.put(0,new LinkedList<BTreeNode>());
	hmp.get(lev).add(root);
	while(!q1.isEmpty()){
			BTreeNode curr=q1.poll();
			while(curr!=null)
			{
				if(curr.left!=null) {
					if(hmp.get(lev+1)==null)
					{
					hmp.put(lev+1, new LinkedList<BTreeNode>());
					}
					hmp.get(lev+1).add(curr.left);
					q1.add(curr.left);
				}
				curr=curr.right;
				if(curr!=null)
				hmp.get(lev).add(curr);
			}
			lev=lev+1;
		}
	for(Entry<Integer, LinkedList<BTreeNode>> me : hmp.entrySet()){
		while(!me.getValue().isEmpty())
		{
			System.out.print(" "+me.getValue().removeFirst().data);
		}
		System.out.println(" ");
	}
	}
}
