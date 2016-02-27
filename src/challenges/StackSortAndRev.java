package challenges;

import java.util.*;
public class StackSortAndRev {
	
	public static void main(String[] args){
		int[] array2=new int[]{1,2,3,4,5,6};
		Stack<Integer> st=new Stack<Integer>();
		st.push(45);
		st.push(46);
		st.push(25);
		st.push(95);
		st.push(28);
		st.push(10);
		sortStackRec(st);
		while(!st.isEmpty())
		{
			System.out.print(" " + st.pop());
		}
	
	}

	private static void sortStackRec(Stack<Integer> st) {
	if(st.isEmpty())
		return;
	int top=st.pop();
	sortStackRec(st);
	insert(st,top);
	}

	private static void insert(Stack<Integer> st, int top) {
		if(st.isEmpty()){
			st.push(top);
			return;
		}
		if(top<st.peek()){
			int temp=st.pop();
			insert(st,top);
			st.push(temp);
		}
		else
		{
			st.push(top);
		}
	}

	private static Stack<Integer> sortStacknonRec(Stack<Integer> st) {
	Stack<Integer> st2=new Stack<Integer>();
	while(!st.isEmpty()){
		int top=st.pop();
		while(!st2.isEmpty()&&top<st2.peek()) {
			st.push(st2.pop());
		}
		st2.push(top);
	}
		return st2;
	}

	
}
