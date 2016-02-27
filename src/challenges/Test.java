package challenges;

import java.util.*;
import java.util.Stack;

public class Test {
	
	public static void main(String[] args){
		String[] value={"{([])}","}","{{{}}","()[]"};
		String[] ret=Braces(value);
		for(String c:ret){
			System.out.println(c);
		}
		
		int[] arrsum={4,1,2,3,4};
		System.out.println(checkSum(arrsum,6));
		String j=negabinary(15);
		System.out.println(j);
	}

	private static String negabinary(int i) {
		StringBuilder sb=new StringBuilder();
		while(i!=0){
			int rem=i%-2;
			i=i/-2;
			if(rem<0){
				rem=rem+2;	
				i+=1;
			}
			sb.append(rem);
		}
		return sb.reverse().toString();		
	}

	private static boolean checkSum(int[] arrsum, int sum) {
		Queue<Integer> q1=new LinkedList<Integer>();
		int currSum=0;
		int reqSum=sum;
		for(int i=0;i<arrsum.length;i++){
			if(currSum+arrsum[i]==reqSum){
				return true;
			}
			if(currSum+arrsum[i]<reqSum){
				q1.add(arrsum[i]);
				currSum+=arrsum[i];
			}else if(currSum+arrsum[i]>reqSum){
				q1.poll();
				currSum=q1.peek()+arrsum[i];
				q1.add(arrsum[i]);
			}
		}
		return false;
	}

	static String[] Braces(String[] values) {
        if(values == null || values.length == 0)
            return values;
        List<String> result = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>();
        boolean flag = false;
        for(String s: values){
            flag = false;
            for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if (s.charAt(i)==')' && !stack.isEmpty() && stack.peek().equals('('))
                stack.pop();
            else if (s.charAt(i)=='}' && !stack.isEmpty() && stack.peek().equals('{'))
                stack.pop();
            else if (s.charAt(i)==']' && !stack.isEmpty() && stack.peek().equals('['))
                stack.pop();
            else{
                result.add("NO");
                flag = true;
                break;
            }    
        }
            if((!flag) && stack.isEmpty())
                result.add("YES");
            else if(!flag && !stack.isEmpty())
            {   
            	result.add("NO");
            }
        }
        
        String[] newList = new String[result.size()];
        return result.toArray(newList);
    }
}
