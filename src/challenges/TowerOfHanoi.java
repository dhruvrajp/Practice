package challenges;

public class TowerOfHanoi {
public static void main(String[] args)
{
	int n=3;
	String start="a";
	String aux="b";
	String end="c";
	hanoiSolve(4,start,end,aux);
	}

//* O(2^n)
private static void hanoiSolve(int i, String start, String end, String aux) {
	if(i==1)
	{
	System.out.println(start+"->"+end+" "+i);
	return;
	}	
	hanoiSolve(i-1,start,aux,end);
	System.out.println(start+"->"+end+" "+i);
	hanoiSolve(i-1,aux,end,start);
	
}
}
