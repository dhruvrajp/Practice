package queue;
import java.util.*;

public class Interleave {
public static void main(String[] args)
{
java.util.Queue<Integer> q1=new LinkedList<Integer>();
java.util.Queue<Integer> q2=new LinkedList<Integer>();
Stack<Integer> s1=new Stack<Integer>();
for(int i=0;i<9;i++)
{
	q1.add(i);
}
int half=(int)Math.ceil((double)q1.size()/2);
System.out.println("Size "+half%2+"\n");
for(int i=0;i<half;i++)
{
	q2.add(q1.poll());
}
if(half%2==0)
{
	for(int i=0;i<half;i++)
	{
		q1.add(q2.poll());
		q1.add(q1.poll());
	}
}
else
{
	for(int i=0;i<half-1;i++)
	{
		q1.add(q2.poll());
		q1.add(q1.poll());
	}
	q1.add(q2.poll());
}
while(!q1.isEmpty())
{
	System.out.print(q1.poll());
}
}
}
