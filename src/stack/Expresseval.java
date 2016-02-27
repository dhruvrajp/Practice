package stack;

import java.util.Scanner;
import java.util.Stack;

public class Expresseval {
public static void main(String[] args)
{
LLStack lstack=new LLStack();
System.out.println("Postfix");
Scanner s=new Scanner(System.in);
String line=s.nextLine();
int result=0;
	for(int i=0;i<line.length();i++)
	{
		String in=line.substring(i, i+1);
		if(in.matches("\\+|\\-|\\*|\\/"))
		{
			int oper1=lstack.pop();
			int oper2=lstack.pop();
			switch (in.charAt(0))
			{
			case '*':
				result=oper1*oper2;
				lstack.push(result);
				break;
			case '+':
				result=oper1+oper2;
				lstack.push(result);
				break;
			case '-':
				result=oper1*oper2;
				lstack.push(result);
				break;
			case '/':
				result=oper1*oper2;
				lstack.push(result);
				break;
			}
		}
		else 
		{
			lstack.push(Integer.parseInt(in));
			
		}
	}
System.out.println("Result "+lstack.pop());	

java.util.Stack<Integer> st=new java.util.Stack<Integer>();
st.push(5);
st.push(6);
st.push(1);
st.push(10);
st.push(2);
sort(st);
while(!st.isEmpty())
{
	System.out.println(st.pop());
}
}
private static void sort(Stack<Integer> st) {
	if(st.empty()!=true)
	{
	int element=st.pop();
	sort(st);
	rearrange(st,element);
	}
}

private static void rearrange(Stack<Integer> st, int element) {
	if(st.isEmpty())
	{
		st.push(element);
		return;
	}
	if(element>st.peek())
	{
		int t1=st.pop();
		rearrange(st,element);
		st.push(t1);
	}
	else
	{
		st.push(element);
	}
}
}
