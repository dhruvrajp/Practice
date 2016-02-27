package ctcode;

public class Test1 {

	public static void main(String[] args){
		int n=3;
		char[] str=new char[n+n];
		printParenthUtil(n,n,str,0);
		System.out.println("\n");
		int[] arr={4,5,62,1,1,4,5,23,1,6,7,8};
		int i, max, location, j, temp, len = arr.length; 
		 for (i = 0; i < len; i++) { 
		 max = arr[i]; 
		 location = i; 
		 for (j = i; j < len; j++) { 
		 if (max > arr[j]) { 
		 max = arr[j]; 
		 location = j; 
		 } 
		 } 
		 temp = arr[i]; 
		 arr[i] = arr[location]; 
		 arr[location] = temp; 
		 }
		for(int q:arr)
		{System.out.println(q);}		
	}

	private static void printParenth(int n) {
		char[] str=new char[n+n];
		printParenthUtil(n,n,str,0);
	}

	private static void printParenthUtil(int l, int r, char[] str, int i) {
		if(l<0||r<l)
			return;
		if(l==0&&r==0){
			System.out.print(String.valueOf(str));
		}else{
			if(l>0){
				str[i]='(';
				printParenthUtil(l-1,r,str,i+1);
			}
			if(r>l){
				str[i]=')';
				printParenthUtil(l,r-1,str,i+1);
			}
		}
	}
	
	
}
