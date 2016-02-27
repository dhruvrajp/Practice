package ctcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Practice1 {
	public static void main(String[] args)
	{
	boolean[] chset=new boolean[256];
	Arrays.fill(chset, false);
	String sub1="newsubtest1ok";
	String sub2="subtest1oknew";
	System.out.println("Rotation check");
	String sub3=sub1+sub1;
	if(sub3.contains(sub2)&&sub1.length()==sub2.length())
		System.out.print("True"+"\n");
	else
		System.out.println("False"+"\n");
	String test= "bacdsceredf";
	String spaceRep="THis has some spaces";
	String sb=repSpace(spaceRep);
	System.out.println("Space Rep String  "+sb+"\n");
	for(int i=0;i<test.length();i++)
	{
		char a=test.charAt(i);
		if(chset[a]==false){
			chset[a]=true;
		}else{
		System.out.println(a);
		}
	}
	String test2="This is C-type String!";
	String test3="This is C-type String!";
	System.out.println(revCString(test2));
	System.out.println(revStringWords(test2));
	System.out.println("Removed Dups "+"\n");
	char[] ret=remDups(test3);
	for(char c:ret)
	{
		System.out.print(" "+c);
	}
	System.out.println("\n"+"Removed Dups in Place "+"\n");
	String test4 ="aabccdd";
	char[] ret2=remDupsinPlace(test4);
	for(char c:ret2)
	{
		System.out.print(" "+c);
	}
	String anag1="abcd";
	String anag2="dacb";
	System.out.println(" "+checkAnagON(anag1,anag2));
	}
	
	
	private static String repSpace(String spaceRep) {
		if(spaceRep==null)
				return null;
		char[] ch=spaceRep.toCharArray();
		int i=0,j=0,spcnt=0;
		for(char c:ch)
		{
			if(c==' ')
			{
				spcnt++;
			}
		}
		int newLength=ch.length+spcnt*2;
		char[] ret=new char[newLength];
		for(char c:ch)
		{
			if(c==' ')
			{
				ret[i]='%';
				ret[i+1]='2';
				ret[i+2]='0';
				i=i+3;
			}
			else
			{
				ret[i]=c;
				i=i+1;
			}
		}
		return String.valueOf(ret);
	}


	private static boolean checkAnag(String anag1, String anag2) {
		if(anag1==null||anag2==null)
			return false;
		if(anag1.length()!=anag2.length())
			return false;
		char[] anch1=anag1.toCharArray();
		char[] anch2=anag2.toCharArray();
		Arrays.sort(anch1);
		Arrays.sort(anch2);
		int i=0;
		for(char c:anch1)
		{
			if(anch2[i]!=c)
			{
				return false;
			}
			i++;
		}
		return true;
	}

	private static boolean checkAnagON(String a,String b)
	{
		if(a.length()!=b.length())
			return false;
		int[] letter=new int[256];
		Arrays.fill(letter, 0);
		int i=0;
		for(char c:a.toCharArray())
		{
			letter[c]++;
		}
		for(char c1:b.toCharArray())
		{
			letter[c1]--;
			if(letter[c1]<0)
				return false;
		}
		return true;
		
	}

	private static char[] remDups(String test2) {
		if(test2==null)
				return null;
		if(test2.length()<2)
				return test2.toCharArray();
		char[] ch=test2.toCharArray();
		Arrays.sort(ch);
		boolean[] b1=new boolean[ch.length];
		Arrays.fill(b1, true);
		int tail=0;
		HashSet<Character> hs=new HashSet<Character>();
		for(int i=0;i<ch.length;i++)
		{	
			hs.add(ch[i]);
		}
		ch=new char[hs.size()];
		int i=0;
		for(char c:hs)
		{
			ch[i]=c;
			i++;
		}
		return ch;
	}

	public static char[] remDupsinPlace(String s)
	{
		if(s==null)
			return null;
		if(s.length()<2)
			return s.toCharArray();
		char[] ch=s.toCharArray();
		int tail=1;
		for(int i=1;i<ch.length;i++){
			int j;
			for(j=0;j<tail;j++){
				if(ch[j]==ch[i])break;
			}
			if(j==tail)
			{
				ch[tail]=ch[i];
				tail++;
			}
		}
		ch[tail]=0;
		return Arrays.copyOf(ch,tail);
	}

	public static String revCString(String s)
	{
		char[] data=s.toCharArray();
		for(char a:data)
		{
			System.out.print(" "+a);
		}
		int i=0;int j=data.length-1;
		while(i<j)
		{
			char temp=data[i];
			data[i]=data[j];
			data[j]=temp;
			i++;
			j--;
		}
			
		return new String(data);
		
	}
	
	public static String revStringWords(String s){
		String[] split=s.split(" ");
		int i=0;int j=split.length-1;
		while (i<j)
		{
			String temp=split[i];
			split[i]=split[j];
			split[j]=temp;
			i++;
			j--;
		}
		String res="";
		for(int k=0;k<split.length;k++)
		{
			res=res+split[k];
		}
		return res;
	}
}
