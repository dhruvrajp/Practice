package ccupamaz;

import java.util.*;

public class Pascal {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
         if(numRows<=0) return res;
        ArrayList<Integer> prev=new ArrayList<Integer>();
        prev.add(1);
        res.add(prev);
        for(int i=2;i<=numRows;i++){
            ArrayList<Integer> curr=new ArrayList<Integer>();
            curr.add(1);
            for(int j=0;j<prev.size()-1;j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
            prev=curr;
            res.add(curr);
        }
        return res;
    }
}
