package ccupamaz;

import java.util.*;
public class BTreePostWithoutRecur {
	
	  public boolean isValidBST(TreeNode root) {
		    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
		}
		 
		public boolean isValidBST(TreeNode p, double min, double max){
		    if(p==null) 
		        return true;
		 
		    if(p.val <= min || p.val >= max)
		        return false;
		 
		    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
		}
		
    public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> s=new Stack<TreeNode>();
    List<Integer> ret=new ArrayList<Integer>();
    if(root==null) return ret;
    if(root.right==null&&root.left==null){
    ret.add(root.val);
    return ret;}
    while(true){
        while(root!=null){
            if(root.right!=null)
            s.push(root.right);
            s.push(root);
            root=root.left;
        }
        if(s.isEmpty())
            return ret;
        root=s.pop();
        if(!s.isEmpty()&&root.right!=null&&root.right==s.peek()){
            s.pop();
            s.push(root);
            root=root.right;
        }else{
            ret.add(root.val);
            root=null;
        }
    }
    }
}
