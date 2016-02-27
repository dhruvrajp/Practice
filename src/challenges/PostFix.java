package challenges;

import java.util.Stack;

public class PostFix {
	public static void main(String[] args){
	System.out.println(postfixEval("13+62*7+*"));
	}
	
	static int postfixEval(String s){
		char[] ch=s.toCharArray();
		int oper1=-1,oper2=-1;
		int k=0;
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			if(ch[i]=='*'||ch[i]=='+'||ch[i]=='-'||ch[i]=='/'){
				switch(ch[i]){
				case '+':
					if(!st.isEmpty()&&st.peek()!=null){
						oper1=st.pop();
					}else return -1;
					if(!st.isEmpty()&&st.peek()!=null){
						oper2=st.pop();
					}else return -1;
					k=oper1+oper2;
					st.push(k);
					break;
				case '*':
					if(!st.isEmpty()&&st.peek()!=null){
						oper1=st.pop();
					}else return -1;
					if(!st.isEmpty()&&st.peek()!=null){
						oper2=st.pop();
					}else return -1;
					k=oper1*oper2;
					st.push(k);
					break;	
				case '-':
					if(!st.isEmpty()&&st.peek()!=null){
						oper1=st.pop();
					}else return -1;
					if(!st.isEmpty()&&st.peek()!=null){
						oper2=st.pop();
					}else return -1;
					k=oper2-oper1;
					st.push(k);
					break;
				case '/':
					if(!st.isEmpty()&&st.peek()!=null){
						oper1=st.pop();
					}else return -1;
					if(!st.isEmpty()&&st.peek()!=null){
						oper2=st.pop();
					}else return -1;
					k=oper2/oper1;
					st.push(k);
					break;
				}
			}else{
				st.push(Integer.parseInt(String.valueOf(ch[i])));
			}
		}
		return st.pop();
	}
	
}
