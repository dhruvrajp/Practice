package ccupamaz;

public class StockPrice {
	    public int maxProfit(int[] prices) {
	        if(prices.length==0)return 0;
	        int currLow=0,currHigh=0,i=0;
	        int maxProfit=0;
	        for(i=0;i<prices.length-1;i++){
	            if(prices[i]>prices[i+1]){
	                int temp=prices[i]-prices[currLow];
	                if(temp>maxProfit){
	                    maxProfit=temp;
	                }
	                if(prices[i+1]<prices[currLow]){
	                    currLow=i+1;
	                }
	                }
	            }
	            if(i==prices.length-1&&prices[prices.length-1]>prices[currLow]){
	                int temp2=prices[i]-prices[currLow];
	                if(temp2>maxProfit){
	                    maxProfit=temp2;
	                }
	            }
	             return maxProfit;
	        }
	    }
