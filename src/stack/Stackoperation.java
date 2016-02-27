package stack;

import java.util.Scanner;

public class Stackoperation {
public static void main(String[] args) throws Exception
{
/*	Stack s2=new Stack();
	System.out.println("Enter expression");
	Scanner scan=new Scanner(System.in);
	String str=scan.nextLine();
	boolean flagmatch=true;
	for(int i=0;i<str.length();i++)
	{
	String input=str.substring(i, i+1);
	if(input.equalsIgnoreCase("{")||
			input.equalsIgnoreCase("(")||input.equalsIgnoreCase("["))
	{
		s2.push(input.codePointAt(0));
	}
	else if(input.equalsIgnoreCase("}"))
	{
		int pop=s2.pop();
		String pops=Character.toString((char)pop);
		if(pops.equalsIgnoreCase("{"))
		{
			flagmatch=true;
		}
		else  
		{
			flagmatch=false;
			break;
		}
	}
	else if(input.equalsIgnoreCase("]"))
	{
		int pop=s2.pop();
		String pops=Character.toString((char)pop);
		if(pops.equalsIgnoreCase("["))
		{
			flagmatch=true;
		}
		else 
		{
			flagmatch=false;
			break;
		}
	}
	else if(input.equalsIgnoreCase(")"))
	{
		int pop=s2.pop();
		String pops=Character.toString((char)pop);
		if(pops.equalsIgnoreCase("("))
		{
			flagmatch=true;
		}
		else
		{
			flagmatch=false;
			break;
		}
		
	}
	}
	if(flagmatch==false||!s2.isUnderFlow())
	{
		System.out.println("Error ");
	}
	else
	{
		System.out.println("Balanced");
	}*/	
SetOfStacks sst=new SetOfStacks(5);
sst.push(45);
sst.push(4);
sst.push(5);
sst.push(51);
sst.push(42);
sst.push(43);
sst.push(3);
sst.push(423);
sst.push(434);
sst.push(413);
sst.push(13);
sst.push(43);
sst.push(1);
sst.push(4213);
sst.push(4133);
sst.push(4113);
sst.push(4103);
System.out.println(sst.pop());
System.out.println(sst.popAt(1));
LLStack s3=new LLStack();
s3.push(5);
s3.push(3);
s3.push(4);
s3.push(9);
s3.push(1);
s3=s3.reversal(s3);
System.out.println(s3.pop());
System.out.println(s3.pop());
System.out.println(s3.pop());
System.out.println(s3.pop());
System.out.println(s3.pop());
s3.push(5);
s3.push(3);
s3.push(4);
s3.push(9);
s3.push(1);
LLStack sorts3=s3.sort(s3);
while(sorts3.headnode!=null)
{
System.out.println("SOrted "+ sorts3.pop());
}
}

}
