package challenges;

import java.util.ArrayList;
import java.util.List;

public class CombSum {
	public static void main(String[] args){
		int[] a={2,4};
		List<List<Integer>> res=combinationSum(a,8);
		for(List<Integer> li:res){
			for(Integer i:li){
				System.out.print(" "+i);
			}
			System.out.println();
		}
		
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)
        return null;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer> curr=new ArrayList<Integer>();
        combinationUtil(candidates,curr,0,target,res);
        return res;
    }
    
    static void combinationUtil(int[] cand,ArrayList<Integer> curr,int j,int target,List<List<Integer>> res){
        if(target==0){
            ArrayList<Integer> temp=new ArrayList<Integer>(curr);
            res.add(temp);
            return;
        }else {
            if(target<0){
                return;
            }else{
                for(int i=j;i<cand.length;i++){
                    curr.add(cand[i]);
                    combinationUtil(cand,curr,i,target-cand[i],res);
                    curr.remove(curr.size()-1);
                }
            }
            
        }
    }
    
}
    