package leetCode;

import java.util.Arrays;
import java.util.*;

public class Sum3 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length<3){
            return res;
        }
        for(int i=0;i<nums.length-2;i++){
            if(i==0||nums[i]>nums[i-1]){
                int neg=-nums[i];
                int start=i+1;
                int end=nums.length-1;
                while(end>start){
                    if(nums[start]+nums[end]==neg){
                        ArrayList<Integer> comb=new ArrayList<Integer>();
                        comb.add(nums[i]);
                        comb.add(nums[start]);
                        comb.add(nums[end]);
                        res.add(comb);
                        start++;
                        end--;
                        while(end>start&&nums[end]==nums[end+1]){
                            end--;
                        }
                        while(end>start&&nums[start]==nums[start-1]){
                            start++;
                        }
                    }else{
                        if(nums[start]+nums[end]>neg){
                            end--;
                        }else{
                            start++;
                        }
                    }
                }
            }
            }
            return res;
        }
}
