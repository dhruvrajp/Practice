package leetCode;

import java.util.*;
public class LongestValidParenth {
	public int longestValidParentheses(String s) {
        if(s==null||s.length()==0)
        return 0;
        int currLen=0,ret=0;
        Stack<int[]> st=new Stack<int[]>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int[] a={i,0};
                st.push(a);
            }else{
                if(st.isEmpty()||st.peek()[1]==1){
                    int[] a={i,1};
                    st.push(a);
                }else{
                    st.pop();
                    if(st.isEmpty()){
                        currLen=i+1;
                    }else{
                        currLen=i-st.peek()[0];
                    }
                    ret=Math.max(currLen,ret);
                }
            }
            
        }
        return ret;
    }
}
