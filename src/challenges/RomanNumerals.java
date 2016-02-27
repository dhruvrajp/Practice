package challenges;

public class RomanNumerals {
		public static void main(String[] args){
			int i=romanToInt("IVMCXDL");
			System.out.println(i);
		}
	
	
	     public static int romanToInt(String s) {
	        if(s==null||s.length()==0)
	            return 0;
	        int result=0;
	        int i=0;
	        while(i<s.length()-2){
	        if(intValue(s.charAt(i))!=-1&&intValue(s.charAt(i+1))!=-1){
	        if(intValue(s.charAt(i))<intValue(s.charAt(i+1))){
	            result-=intValue(s.charAt(i));
	        } else{
	            result=result+intValue(s.charAt(i));
	        }
	            i++;
	        }
	        else{
	            System.out.println("Invalid Input");
	            break;
	        }
	        }
	        return result;
	    }
	    
	    
	    public static int intValue(char s)
	    {
	        switch(s){
	            case 'I': return 1;
	            case 'V':return 5;
	            case 'X': return 10;
	            case 'L':return 50;
	            case 'C': return 100;
	            case 'D':return 500;
	            case 'M':return 1000;
	            
	        }
	        return -1;
	    }
	    
	}
	
