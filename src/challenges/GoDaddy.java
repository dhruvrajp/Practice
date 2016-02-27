package challenges;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class GoDaddy {

	public static void main(String[] a)
	{
		int count=0;
		Stack<Character> stac=new Stack<Character>();
		String test="abc";
		System.out.println("\n"+compress(test));		
	}
	
	
	static String compress(String str) {
        int size=checkSize(str);
 //       if(size>=str.length())
 //           return str;
        int count=1;
        StringBuffer mystr=new StringBuffer();
        char c=str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            if(c==str.charAt(i))
            {
                count++;
            }
               else
            {
                mystr.append(c);
                if(count>1)	
                mystr.append(count);
                c=str.charAt(i);
                count=1;
            }
            
        }
          mystr.append(c);
          if(count>1)
          mystr.append(count);
          return mystr.toString();

    }
	
	 static int checkSize(String str) 
     {
       if(str==null||str.isEmpty()) 
           return 0;
        char last=str.charAt(0);
        int size=0;
        int count=1;
        for(int i=1;i<str.length();i++)
        {
        if(str.charAt(i)==last)
           {
           count++; 
           }
        else
           {
           last=str.charAt(i);
           size=size+1+String.valueOf(count).length();
           count=1; 
           }
        }
        size=size+1+String.valueOf(count).length();
        return size;
                  
     }
}
