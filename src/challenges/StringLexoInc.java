package challenges;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StringLexoInc {

    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       String new1 = null;
       int k=0,l=0;
        int count=s.nextInt();
        s.nextLine();
        boolean swapped;
        for(int cnt=0;cnt<count;cnt++)
        {
         
          swapped=false;
          String w=s.nextLine();
          char[] c=w.toCharArray();
          for(int i=c.length-1;i>0;i--)
          {
        	if((int)c[i]>(int)c[i-1])
        	{
        	k=i-1;	
        	swapped=true;
        	break;	
        	}
          }
          if(swapped==true)
          {
          for(int i=c.length-1;i>0;i--)
          {
        	 if((int)c[k]<(int)c[i]) 
        	 {
        		l=i; 
        		break;
        	 }
          }
          char temp=c[k];
          c[k]=c[l];
          c[l]=temp;
          String output=String.valueOf(c);
          StringBuilder half1=new StringBuilder(output.substring(0, k+1));
          StringBuilder sb=new StringBuilder(output.substring(k+1, output.length()));
          StringBuilder half=sb.reverse();
          output=half1.toString()+half.toString();
          System.out.println(output);	  
          }
          else
          {
        	System.out.println("no answer");  
        	  
          }
      
        }
    }
}