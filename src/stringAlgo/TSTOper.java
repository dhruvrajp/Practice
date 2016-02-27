package stringAlgo;

import java.util.*;

public class TSTOper {
	 public static int[] f;
	  public static void main(String[] args) {
	    TST t=new TST();
	    t.insert("New");
	    t.insert("Ports");
	    t.insert("Nic");
	    t.insert("Nice");
	    System.out.println(t.search("Nic"));
	    System.out.println(t.search("New"));
	    t.displayAll();
	  }
	 
	}
	  
	class TSTNode{
	  char data;
	  boolean endMark;
	  TSTNode left;
	  TSTNode eq;
	  TSTNode right;
	  
	  TSTNode(){
	    this.endMark=false;
	    this.left=null;
	    this.right=null;
	    this.eq=null;
	  }
	}  
	  
	  
	class TST{
	  TSTNode root;
	  public void insert(String s){
	    root=insertTST(root,s,0);
	    System.out.println("Inserted");
	  }
	  
	  public TSTNode insertTST(TSTNode curr,String s,int pos){
	 //   char[] ch=s.toCharArray();
	    if(curr==null){
	      curr=new TSTNode();
	      curr.data=s.charAt(pos);
	    }
	    if(curr.data>s.charAt(pos)){
	      curr.left=insertTST(curr.left,s,pos);
	    }
	    else if(curr.data<s.charAt(pos)){
	      curr.right=insertTST(curr.right,s,pos);
	    }
	    else{
	      if(pos<s.length()-1){
	        curr.eq=insertTST(curr.eq,s,pos+1);
	      } else{
	        curr.endMark=true;
	      }
	    }
	    return curr;
	    }
	  
	  public boolean search(String s){
	   return  searchTST(root,s,0);
	  }
	  
	  public boolean searchTST(TSTNode curr,String s, int pos){
	    if(curr==null)
	      return false;
	    if(s.charAt(pos)<curr.data){
	      return searchTST(curr.left,s,pos);
	    }
	    if(s.charAt(pos)>curr.data){
	      return searchTST(curr.right,s,pos);
	    }
	    else
	    {
	      if(pos==s.length()-1&&curr.endMark==true){
	        return true;
	      }
	      else if(pos==s.length()-1){
	        return false;
	      }
	      else
	        return searchTST(curr.eq,s,pos+1);
	    }
	    
	  }
	  public void displayAll(){
		    display(root); 
		  }
		  
		  String word="";
		  int i=0;
		  public void display(TSTNode root){
		    if(root==null) return;
		    display(root.left);
		    word=word+root.data;
		    if(root.endMark==true){
		      System.out.println(word);
		    }
		    i++;
		    display(root.eq);
		    i--;
		    display(root.right);
		  }
	  }
