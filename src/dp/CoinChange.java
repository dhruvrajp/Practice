package dp;

import java.util.*;
public class CoinChange {
	public static void main(String[] args){
		
		}
	 public static int coinChange(int[] coins, int amount) {
	        return coinChangeUtil(coins,0,amount);
	    }
	    
	   public static int coinChangeUtil(int[] coins,int i,int amount){
	        if(amount<=0)
	            return 0;
	        if(amount==coins[i]){
	            return 1;
	        }
	        if(i==coins.length-1 && amount>0){
	            return 0;
	        }
	        return coinChangeUtil(coins,i,amount-coins[i])+coinChangeUtil(coins,i+1,amount);
	    }
	   
	   
	   static int maxCoins(int n, int[]coins){
	        int[] results = new int[n+1];
	        results[0] = 1;
	        for(int i=0; i<coins.length; i++)
	        {
	        	for(int j=coins[i]; j<=n; j++)
	        	{
	    	   //*Value of previous subproblems + picking this coin
	        		results[j] += results[j - coins[i]];
	        	}
	        }
	  
	    return results[n];
	    }
	   
	   
	   public int mincoinChange(int[] coins, int amount) {
	        if (coins==null || coins.length==0)
	        return -1;
	        if(amount <= 0)
	        return 0;
	        int[] curr=new int[amount+1];
	        Arrays.fill(curr,Integer.MAX_VALUE-1);
	        curr[0]=0;
	        for(int i=1;i<amount+1;i++){
	            for(int j=0;j<coins.length;j++){
	                if(i-coins[j]>=0){
	                curr[i]=Math.min(curr[i],1+curr[i-coins[j]]);
	                }
	            }
	        }
	         if(curr[amount]==Integer.MAX_VALUE-1){
	                curr[amount]=-1;
	            }
	       return curr[amount];
	    
	}
		   
}
	
