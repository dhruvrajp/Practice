package stack;

public class SpanFinder {
public static void main(String[] args)
{
int[] arr={6,4,5,2,6,7,8,1};
int[] spans=spanfinder(arr);
for(int i=0;i<spans.length;i++)
{
	System.out.println(spans[i]);
}
}

private static int[] spanfinder(int[] arr) {
	// TODO Auto-generated method stub
	
	int length=arr.length;
	int[] spans=new int[length];
	int p=0;
	LLStack stk=new LLStack();
	for(int i=0;i<length;i++)
	{
		while(stk.headnode!=null&&arr[i]>=arr[stk.top()])
		{
			stk.pop();
		}
		if (stk.headnode==null)
				p=-1;
		else
			p=stk.top();
		spans[i]=i-p;	
		stk.push(i);
	}
	return spans;
}
	
}
