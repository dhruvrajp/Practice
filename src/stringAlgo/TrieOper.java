package stringAlgo;

import java.util.*;

public class TrieOper {
	public static void main(String[] args)
	{
		Trie t=new Trie();
		String s="John Kigh";
		StringTokenizer st=new StringTokenizer(s," ");
		while(st.hasMoreTokens())
		{
			t.insert(st.nextToken());
		}
		String search="John Joiz Jodi";
		StringTokenizer sc=new StringTokenizer(search," ");
		boolean flag=false;;
		while(sc.hasMoreTokens())
		{
			flag=t.searchTrie(sc.nextToken());
			if(flag==false) break;
		}
		System.out.println(flag);	
		System.out.println(t.searchTrie("High"));
		System.out.println(t.searchTrie("Joiz"));
		System.out.println(t.searchTrie("Jodi"));
		System.out.println(t.getNext("John"));
	}
}

class Trie{
	TrieNode root;
	Trie(){
		root=new TrieNode();
	}
	
	public void insert(String s){
		char[] ch=s.toCharArray();
		TrieNode curr=root;
		LinkedList<TrieNode> children=curr.children;
		for(int i=0;i<ch.length;i++){
			TrieNode sub=curr.subChild(ch[i]);
			if(sub==null)
			{
				curr=new TrieNode();
				curr.data=ch[i];
				children.add(curr);
			}
			else
			{
				curr=sub;
			}
			children=curr.children;
			if(i==ch.length-1)
			{
				curr.isLeaf=true;
			}
			}
	}
	
	public boolean searchTrie(String s){
		TrieNode curr=root;
		char[] ch=s.toCharArray();
		for(int i=0;i<ch.length;i++){
			TrieNode sub=curr.subChild(ch[i]);
			if(sub!=null)
			{
				curr=sub;
				if(i==ch.length-1)
					return true;
			}
		}
		return false;
	}
	
	public String getNext(String s){
	String ret="";
	for(int i=s.length()-1;i>=0;i--){
	char c=s.charAt(i);
	int j=c;
	String rem=s.substring(0, i);
	String chk=rem+((char)(j+1));
	for(j=j+1;j<'z';j++){
		if(searchTrie(rem+(char)j)==true){
			ret=""+rem+(char)j;
			return ret;
		}
	}
	}
	return null;
	}
	
}


class TrieNode{
	
	char data;
	LinkedList<TrieNode> children;
	boolean isLeaf;
	TrieNode(){
		children=new LinkedList<TrieNode>();
	}
	
	TrieNode(char data){
		this.data=data;
		children=new LinkedList<TrieNode>();
		isLeaf=false;
	}
	
	public TrieNode subChild(char c){
		if(children==null)return null;
		for(TrieNode child:children){
			if(child.data==c){
				return child;
			}
		}
		return null;
	}
	
}