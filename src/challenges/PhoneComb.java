package challenges;

import java.util.*;

public class PhoneComb {
	public static void main(String[] args){
		  
		        List<String> retSet=new ArrayList<String>();
		        HashMap<Integer,String> map=new HashMap<Integer,String>();
		        map.put(2, "abc");
		        map.put(3, "def");
		        map.put(4, "ghi");
		        map.put(5, "jkl");
		        map.put(6, "mno");
		        map.put(7, "pqrs");
		        map.put(8, "tuv");
		        map.put(9, "wxyz");
		        map.put(0, "");
		       
		       ArrayList<Character> temp=new ArrayList<Character>();
		       getComb("234",temp,map,retSet);
//		       return retSet;
		       for(String s:retSet){
		    	   System.out.println(s);
		       }
		      LinkedHashMap<Integer,Integer> lmp=new LinkedHashMap<Integer,Integer>();
		      	
		       int n=5;
		       printParenth(n);
		       
		    } 
	
	private static void printParenth(int n) {
		ArrayList<String> retSet=new ArrayList<String>();
		genPareUtil(retSet,"",n-1,n-1);
		for(String s:retSet){
			System.out.println(s);
		}
	}

	private static void genPareUtil(ArrayList<String> retSet, String s, int left, int right) {
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
	        
	        if(right>left){
	            genPareUtil(retSet,s+")",left,right-1);
	        }
	        
	}

	public static void getComb(String digits,ArrayList<Character> temp,HashMap<Integer,String> map,List<String> retSet){
	       if(digits.length()==0){
	           char[] ch=new char[temp.size()];
	           for(int i=0;i<temp.size();i++){
	            ch[i]=temp.get(i);                   
	           }
	           retSet.add(String.valueOf(ch));
	           return;
	       }
	       Integer curr=Integer.valueOf(digits.substring(0,1));
	       String val=map.get(curr);
	       for(int i=0;i<val.length();i++){
	           temp.add(val.charAt(i));
	           getComb(digits.substring(1),temp,map,retSet);
	           temp.remove(temp.size()-1);
	       }

	    }
	    
}