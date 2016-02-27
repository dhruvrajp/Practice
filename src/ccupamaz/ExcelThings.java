package ccupamaz;

public class ExcelThings {
	public int titleToNumber(String s) {
        int ind=0;
        int sum=0;
        for(int i=s.length()-1;i>=0;i--){
            sum+=(int)Math.pow(26,ind)*(s.charAt(i)-'A'+1);
            ind++;
        }
        return sum;
        
    }
	
	  public String convertToTitle(int n) {
	        String s="";
	       StringBuilder sb=new StringBuilder();
	       while(n>0){
	           n--;
	           char ch=(char)(n%26+'A');
	           n=n/26;
	           sb.append(ch);
	       }
	       return sb.reverse().toString();
	}	

}
