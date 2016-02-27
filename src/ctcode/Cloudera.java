package ctcode;

import java.util.Arrays;
import java.util.Stack;

public class Cloudera {
public static void main(String[] args){
	String s="45+5*1-";
	System.out.println(Solu(s));	
}


public static int Solu(String S){
	 char[] ch=S.toCharArray();
     Stack<Integer> st=new Stack<Integer>();
     int i=0,j=0,k=0;
     while(i<ch.length){
     if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/'){  
     switch(ch[i]){
     case '+':   
     if(!st.isEmpty()){
     k=st.pop();
     }else{return -1;}
     if(!st.isEmpty()){
     j=st.pop();
     st.push(k+j);
     }else {return -1;}
     break;
   
     case '*':
     if(!st.isEmpty()){
     k=st.pop();
     }else{return -1;}
     if(!st.isEmpty()){
     j=st.pop();
     st.push(k*j);
     }else {return -1;}
     break;
     
     case '-':
     if(!st.isEmpty()){
     k=st.pop();
     }else{return -1;}
     if(!st.isEmpty()){
     j=st.pop();
     st.push(k-j);
     }else {return -1;}
     break;

     case '/':
     if(!st.isEmpty()){
     k=st.pop();
     }else{return -1;}
     if(!st.isEmpty()){
     j=st.pop();
     st.push(k/j);
     }else {return -1;}
     break;
     }
     i++;
     }    
     else{
    	 st.push(Character.getNumericValue(ch[i]));
    	 i++;
     }
     }
     return st.pop();
}
}
