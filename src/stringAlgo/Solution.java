package stringAlgo;

import java.io.*;
import java.util.*;

public class Solution {
  public static int[] f;
  public static void main(String[] args) {
  String text="This is a matching pattern twice pattern";
  String match="pattern";
  int res=kmp(text,match); 
  System.out.println(res);
  }
  
 static int kmp(String t,String p) {
   int i=0,j=0;
   char[] txt=t.toCharArray();
   char[] pat=p.toCharArray();
   kmpPrefix(p);
   while(i<txt.length){
     if(txt[i]==pat[j]){
       if(j==pat.length-1){
         return i-j;
       }
       i++;
       j++;
     }
     else if(j>0){
       j=f[j-1];
     }
     else{
       i++;
     }
   }
   return -1;
 }
   
  static void kmpPrefix(String p){
    f=new int[p.length()];
    int len=p.length();
    int i=1,j=0;
    char[] pat=p.toCharArray();
    while(i<len){
      if(pat[i]==pat[j]){
        f[i]=j+1;
        i++;
        j++;
      }
      else if(j>0){
        j=f[j-1];
      }
      else{
        f[i]=0;
        i++;
      }
    }
    System.out.println("Exit 1");
    
  }  
}