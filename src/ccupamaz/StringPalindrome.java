package ccupamaz;

import java.util.Arrays;

public class StringPalindrome {
	public static void main(String[] args){
		String pal="afbda";
		int i=recursePalseq(pal.toCharArray(),0,pal.length()-1);
		System.out.println(i);
		int j=dpPal(pal.toCharArray());
		System.out.println(j);
		String subpal="aacvdfsaabaasds";
		System.out.println(subpal(subpal));
	}

	private static int subpal(String subpal) {
		char[] ch=subpal.toCharArray();
		int maxLen=0;
		int start=0;
		boolean[][] table=new boolean[ch.length][ch.length];
		for(int i=0;i<ch.length;i++){
			table[i][i]=true;
		}
		for(int i=0;i<ch.length-1;i++){
			if(ch[i]==ch[i+1]){
				table[i][i+1]=true;
				start=i;
				maxLen=2;
			}
		}
		int j=0;
		for(int k=3;k<ch.length;k++){
			for(int i=0;i<ch.length-k+1;i++){
				j=i+k-1;
				if(table[i+1][j-1]==true&&ch[i]==ch[j]){
					table[i][j]=true;
					if(k>maxLen){
						maxLen=k;
						start=i;
					}
				}
			}
		}
		return maxLen;
	}

	private static int dpPal(char[] ch) {
		int[][] table=new int[ch.length][ch.length];
		for(int i=0;i<ch.length;i++){
			table[i][i]=1;
		}
		for(int cl=2;cl<=ch.length;cl++){
			for(int i=0;i<ch.length-cl+1;i++){
				int j=i+cl-1;
				if(cl==2&&ch[i]==ch[j]){
					table[i][j]=2;
				}else if(ch[i]==ch[j]){
					table[i][j]=table[i+1][j-1]+2;
				}else{
					table[i][j]=Math.max(table[i+1][j], table[i][j-1]);
				}
			}
		}
		return table[0][ch.length-1];
	
	}

	private static int recursePalseq(char[] ch, int i, int j) {
		if(j-i==1)
			return 1;
		if(j-i==0)
			return 0;
		if(ch[i]==ch[j]){
			return recursePalseq(ch,i+1,j-1)+2;
		}else{
			return Math.max(recursePalseq(ch,i+1,j), recursePalseq(ch,i,j-1));
		}
	}

	
}
