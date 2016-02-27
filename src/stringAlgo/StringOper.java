package stringAlgo;

public class StringOper {
	public static void main(String[] args){
		String a="This is the main string";
		String b="n string";
		System.out.println(bruteForceCheck(a,b));
		String perm="abcd";
		permute(perm);
		combination(perm);
		String testdup="ABCCBCBA";
		System.out.println("\n"+recurseRemDup(testdup));
		String testdup2="AAABCCBCBADB";
		System.out.println("new " +remDup(testdup2));
	}

	
public static String removeDuplicateLetters(String s) {
       s.contentEquals("#");
       
		if(s==null||s.length()==0)
        return s;
        char[] ch=s.toCharArray();
        int[] arr=new int[256];
        int count=1;
        for(int i=ch.length-1;i>=0;i--){
            if(arr[ch[i]]!=1){
                arr[ch[i]]=1;
            }else{
                for(int j=i+1;j<ch.length;j++){
                    ch[j-1]=ch[j];
                }
                count++;
            }
        }
        return String.valueOf(ch,0,ch.length-count+1);
	}
	
	private static String remDup(String testdup) {
		char[] str=testdup.toCharArray();
		int tail=1;
		for(int i=1;i<str.length;i++){
			int j;
			for(j=0;j<tail;j++){
				if(str[i]==str[j]){
					break;
				}
			}
			if(j==tail){
				str[tail]=str[i];
				tail++;
			}
		}
		return String.valueOf(str).substring(0, tail);
	}

	private static String recurseRemDup(String s) {
		int j=s.length()-1;
		return recurseRemUtil(s);
	}

	private static String recurseRemUtil(String s) {
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==s.charAt(i-1)){
				s=s.substring(0,i-1)+s.substring(i+1,s.length());
				s=recurseRemUtil(s);
			}
	}
		return s;
	}
	private static void combination(String perm) {
		System.out.println("\n");
		combinationUtil("",perm);
		
	}

	private static void combinationUtil(String prefix, String s) {
		if (s==null)return;
		System.out.print(" "+prefix);
		for(int i=0;i<s.length();i++){
			combinationUtil(prefix+s.charAt(i),s.substring(i+1));
			}
	}
	
	private static void permute(String perm) {
		permutationInOrder("",perm);
	}

	private static void permutationInOrder(String pref,String s) {
		int len=s.length();
		if(len==0){
			System.out.print(" "+pref);
		}

		for(int i=0;i<len;i++){
			permutationInOrder(pref+s.charAt(i),s.substring(0,i)+s.substring(i+1,len));
		}
	}
	
	
	public static void permNtInOr(String perm){
		int len=perm.length();
		char[] a=perm.toCharArray();
		for(int i=0;i<len;i++){
			a[i]=perm.charAt(i);
		}
		System.out.println(" ");
		permutationNotIn(a,len);
	
	}

	private static void permutationNotIn(char[] a, int len) {
		if(len==1){
			System.out.print(" "+String.valueOf(a));
			return;
		}
		for(int i=0;i<len;i++){
			swap(a,i,len-1);
			permutationNotIn(a,len-1);
			swap(a,i,len-1);
		}
	}

	private static void swap(char[] a, int i, int j) {
		char c;
		c=a[i];a[i]=a[j];a[j]=c;
	}

	private static boolean bruteForceCheck(String a, String b) {
		char[] cha=a.toCharArray();
		char[] chb=b.toCharArray();
		for(int i=0;i<=(cha.length-chb.length);i++){
			int j=0;
			while(j<chb.length&&cha[i+j]==chb[j]){
				j++;
			}
			if(j==chb.length)
				return true;
		}
		return false;
	}
}
