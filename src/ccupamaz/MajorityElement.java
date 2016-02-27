package ccupamaz;

import java.util.Arrays;

public class MajorityElement {
	
	public int majorityElementOptim(int[] nums) {
	       int count=0,result=0;
	       for(int i=0;i<nums.length;i++){
	           if(count==0){
	               result=nums[i];
	               count=1;
	           }else if(result==nums[i]){
	               count++;
	           }else{
	               count--;
	           }
	       }
	       return result;
	    }
	
	 public int majorityElement(int[] nums) {
	        if(nums.length==1){
	            return nums[0];
	        }
	        Arrays.sort(nums);
	        int count=1;
	        for(int i=1;i<nums.length;i++){
	            if(nums[i]==nums[i-1]){
	                count++;
	                if(count>(nums.length/2)){
	                    return nums[i];
	                }
	            }else{
	                count=1;
	            }
	        }
	        return -1;
	    }
	
}
