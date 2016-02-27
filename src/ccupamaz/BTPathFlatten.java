package ccupamaz;

import java.util.*;

public class BTPathFlatten {
		public static void main(String[] args){
			
		}
	
	    public List<String> binaryTreePaths(TreeNode root) {
	        List<String> retList=new ArrayList<String>();
	        String s="";
	        binaryTreePathsUtil(root,retList,s);
	        return retList;
	    }
	    
	    public void binaryTreePathsUtil(TreeNode root,List<String> retList,String s)
	    {
	        if(root==null)
	        return;
	        if(root.left==null&&root.right==null){
	            s=s+root.val;
	            retList.add(s);
	            return;
	        }
	        
	        binaryTreePathsUtil(root.left,retList,s+root.val+"->");
	        binaryTreePathsUtil(root.right,retList,s+root.val+"->");
	        
	    }
	    //*Simple flattening Preorder Style
	    public void flatten(TreeNode root) {
	        Stack<TreeNode> st=new Stack<TreeNode>();
	        TreeNode curr=root;
	        while(curr!=null||!st.isEmpty()) {
	            if(curr.right!=null){
	                st.push(curr.right);
	            }
	            if(curr.left!=null){
	                curr.right=curr.left;
	                curr.left=null;
	            }else{
	                if(!st.isEmpty()){
	                TreeNode temp=st.pop();
	                curr.right=temp;
	                }
	            }
	            curr=curr.right;
	        }
	            
	        }
	    
	    
	}


class TreeNode{

	public TreeNode(){}
	public TreeNode(int val2) {
		this.val=val;
	}
	public TreeNode left;
	public TreeNode right;
	int val;
}