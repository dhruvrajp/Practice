package challenges;

public class ArrayCount {
	
	public static void main(String args[]){
		getSortedArray("str1", "str2");
	}

	private static void getSortedArray(String string1, String string2) {
		// TODO Auto-generated method stub
		int[] string1Count = new int[256];
		int[] string2Count = new int[256];
		
		for(int i = 0; i < string1.length(); i++)
		{
			string1Count[string1.charAt(i)] = string1Count[string1.charAt(i)]+ 1; 
		}
		
		for(int i = 0; i < string2.length(); i++)
		{
			string2Count[string2.charAt(i)] += string2Count[string2.charAt(i)] + 1; 
		}
		
		int shorterLength = 0;
		if(string1.length() < string2.length())
			shorterLength = string1.length();
		else
			shorterLength = string2.length();
		
		StringBuilder result = new StringBuilder();
		for(int cnt = 0, i =0; cnt < shorterLength && i < 256; i++)
		{
			if(string1Count[i] > 0 && string2Count[i] > 0)
			{
				result.append(Character.toString((char)i));
				cnt++;
				string1Count[i]--;
				string2Count[i]--;
				
				if(string1Count[i] > 0 && string2Count[i] > 0)
					i--;
					
			}
		}
		
		System.out.println(result.toString());
		
	}

}
