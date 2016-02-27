package challenges;

import java.util.*;
public class WordCheck {
	public static void main(String[] args){
	String s="aaaaaaaaaaa";
	Set<String> set=new HashSet<String>();
	set.add("a");
	
	System.out.println(wordBreak(s,set));
	}
	 static  public boolean wordBreak(String s, Set<String> set) {
	     if(s.length()==0)
	     return true;
	     boolean[] dp=new boolean[s.length()+1];
	     Arrays.fill(dp,false);
	     for(int i=1;i<=s.length();i++){
	         if(dp[i]==false&&set.contains(s.substring(0,i))){
	             dp[i]=true;
	         }
	         
	         if(dp[i]==true){
	             if(i==s.length())
	                return true;
	             for(int j=i+1;j<=s.length();j++){
	                 if(dp[j]==false&&set.contains(s.substring(i,j)))
	                    dp[j]=true;
	                if(j==s.length()&&dp[j]==true)
	                    return true;
	             }
	         }
	     }
	  return false;
}
}
