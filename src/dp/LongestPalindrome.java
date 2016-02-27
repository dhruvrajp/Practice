package dp;

public class LongestPalindrome {
	    public String longestPalindrome(String s) {
	        if(s==null)
	            return null;
	        if(s.isEmpty())
	        if(s.length()<=1)
	            return s;
	            
	        String s1 = s.substring(0,1);
	        for(int i = 0; i < s.length(); i++){
	            String temp = findPalin(s,i,i);
	            if(temp.length()>s1.length())
	                s1 = temp;
	            
	            temp = findPalin(s, i, i+1);
	            if(temp.length() > s1.length())
	                s1 = temp;
	        }
	        return s1;
	    }
	    
	    public String findPalin(String s, int begin, int end){
	        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
	            begin--;
	            end++;
	        }
	        return s.substring(begin+1, end);
	    }
}
