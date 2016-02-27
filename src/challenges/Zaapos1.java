package challenges;

import java.util.HashMap;

public class Zaapos1 {

	public static void main(String[] args){
		String s="abba";
		System.out.println(palindrome(s));
	}
	
	static int palindrome(String str){
		int n = str.length();
		HashMap sub = new HashMap();
		boolean[][] dp = new boolean[n][n];
		
		for(int i=0;i<n;i++){
			dp[i][i] = true;
			sub.put(str.charAt(i), 1);
		}
		for(int i=0;i<n-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				dp[i][i+1]=true;
				sub.put(str.charAt(i)+str.charAt(i+1), 1);
			}
		}
		
		for(int k=3;k<n+1;k++){
			for(int i=0;i<n-k+1;i++){
				int j=i+k-1;
				if(dp[i+1][j-1]==true&&str.charAt(i)==str.charAt(j)){
					dp[i][j]=true;
					sub.put(str.substring(i, j+1),1);
				}
			}
		}
		return sub.size();
		}
		
}
