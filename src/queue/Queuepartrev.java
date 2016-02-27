package queue;

import java.util.*;
public class Queuepartrev {
public static void main(String[] args)
{
java.util.Queue<Integer> q1=new LinkedList<Integer>();
Stack<Integer> s1=new Stack<Integer>();
for(int i=0;i<10;i++)
{
	q1.add(i);
}
int half=q1.size()/2;
for(int i=0;i<half;i++)
{
	s1.push(q1.poll());
}
while(!s1.isEmpty())
{	
	int i=s1.pop();
	q1.add(i);
}
for(int i=0;i<half;i++)
{
	q1.add(q1.remove());
}
while(!q1.isEmpty())
{
	System.out.print(q1.poll());
}
}

}
