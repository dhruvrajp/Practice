package challenges;

public class Kartsuba {
	public static void main(String[] args){
		long x=34567890;
		long y=78921424;
		System.out.println(karsubaMult(x,y));
		
	}

	private static long karsubaMult(long x, long y) {
		if(size(x)<10&&size(y)<10)
		return x*y;
		
		long num=Math.max(x, y);
		int N=size(num)/2;
		long m=(long)Math.pow(10, N);
		
		long a=x/m;
		long b=x-(a*m);
		long c=y/m;
		long d=y-(c*m);
		long z0=karsubaMult(a,c);
		long z1=karsubaMult((a+b),(c+d));
		long z2=karsubaMult(b,d);
		return z0+((z1-z0-z2)*m)+(z2*(long)Math.pow(10, 2*N));
	}

	private static int size(long x) {
		int count=0;
		long num=x;
		while(num!=0){
			num=num/10;
			count++;
		}
		return count;
	}
	
}
