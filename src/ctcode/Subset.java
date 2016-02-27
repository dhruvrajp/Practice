package ctcode;

import java.util.*;
public class Subset {
	public static void main(String[] args){
	int[] nums={1,2,3};	
	subsets(nums);
		
		
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
	    // Sort first, as required.
	    Arrays.sort(nums);
	    List<List<Integer>> lists = new ArrayList<>();
	    // Add an empty set first.
	    lists.add(new ArrayList<Integer>());
	    // For each possible length of subsets, we do DFS and Backtracking.
	    for (int len = 1; len <= nums.length; len++) {
	        dfs(new ArrayList<Integer>(), 0, len, nums, lists);
	    }
	    return lists;
	}

	private static void dfs(List<Integer> cur, int start, int len, int[] nums, List<List<Integer>> lists) {
	    if (cur.size() == len) {
	        // If we've already got enough elements, we stop.
	        lists.add(new ArrayList<Integer>(cur));
	        return;
	    }
	    // Do backtracking from current start point.
	    for (int i = start; i < nums.length; i++) {
	        cur.add(nums[i]);
	        dfs(cur, i + 1, len, nums, lists);
	        cur.remove(cur.size() - 1);
	    }
	}
}
