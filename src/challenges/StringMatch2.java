package challenges;

public class StringMatch2 {
	static int[] f;
	public static void main(String[] args){
	String a="ababbbabc";
	String b="abc";
	System.out.println(stringMatch(a,b));
	System.out.println(kmp(a,b));
	}

	private static int kmp(String a, String b) {
		int i=0,j=0;
		prefTab(b);
		while(i<a.length()){
		if(a.charAt(i)==b.charAt(j)){
			if(j==b.length()-1) return i-j;
			i++;
			j++;
		}else if(j>0){
			j=f[j-1];
		}else{
			i++;
		}
		}
		return -1;
	}

	private static void prefTab(String b) {
		f=new int[b.length()];
		int i=1,j=0;
		while(i<b.length()){
			if(b.charAt(i)==b.charAt(j)){
				f[i]=j+1;
				i++;
				j++;
			}else if(j>0){
				j=f[j-1];
			}else{
				i++;
			}
		}
	}

	private static int stringMatch(String a, String b) {
		char[] cha=a.toCharArray();
		char[] chb=b.toCharArray();
		for(int i=0;i<=cha.length-chb.length;i++){
			int j=0;
			while(j<chb.length&&chb[j]==cha[i+j]){
				j++;
			}
			if(j==chb.length)
				return i;
		}
		return -1;
	}
}
