package challenges;


import java.util.*;
public class NextBig {
	public static void main(String[] args){
		String i="520876";
		System.out.println(nextBig(i));
	}

	private static String nextBig(String s) {
		char[] ch=s.toCharArray();
		int i=ch.length-1;
		boolean ret=false;
		int dig=0;
		while(i>0){
			if(ch[i-1]<ch[i]){
				dig=i-1;
				System.out.println(ch[dig]);
				ret=true;
				break;
			}
			i--;
		}
		if(ret==false){
			return null;
		}
		int tempNMax=Integer.MAX_VALUE;
		int tempMaxVal=Integer.MAX_VALUE;
		for(int j=dig+1;j<ch.length;j++){
			if(ch[j]!='0'&&ch[j]<tempMaxVal){
				tempNMax=j;
				tempMaxVal=ch[j];
			}
		}
		System.out.println(ch[tempNMax]);
		char temp=ch[tempNMax];
		ch[tempNMax]=ch[dig];
		ch[dig]=temp;
		Arrays.sort(ch,dig+1 , ch.length);
		return String.valueOf(ch);
	
	}
	
}
