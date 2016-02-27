package leetCode;

import java.util.*;
public class GenerateParenthsis {
	  public List<String> generateParenthesis(int n) {
	      List<String> retSet=new ArrayList<String>();
	      genPareUtil(retSet,"",n,n);
	      return retSet;
	    }
	    
	     void genPareUtil(List<String> retSet,String s,int left,int right){
	        if(left>right){
	            return;
	        }
	        
	        if(left==0&&right==0){
	            retSet.add(s);
	            return;
	        }
	        
	        if(left>0){
	            genPareUtil(retSet,s+"(",left-1,right);
	        }
	        
	        if(right>0){
	            genPareUtil(retSet,s+")",left,right-1);
	        }
	        
	    }
}
