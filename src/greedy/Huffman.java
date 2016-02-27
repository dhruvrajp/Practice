package greedy;

import java.util.*;
import java.lang.*;
public class Huffman {

public static void main(String[] args){
	String comp="this is an example for huffman encoding";
	char[] ch=comp.toCharArray();
	int[] freq=new int[256];
	for(char c:ch){
		freq[c]++;
	}
	HuffmanTree htree = HuffmanBuild(freq);
	printCode(htree,new StringBuffer());
}

private static void printCode(HuffmanTree htree, StringBuffer stringBuffer) {
	assert htree!=null;
	if(htree instanceof HuffmanLeaf){
		HuffmanLeaf hl=(HuffmanLeaf)htree;
		System.out.println(hl.value+" "+hl.freq+" "+stringBuffer);
	}
	else if(htree instanceof HuffmanNode){
		HuffmanNode hnode=(HuffmanNode)htree;
			stringBuffer.append('0');
			printCode(hnode.left,stringBuffer);
			stringBuffer.deleteCharAt(stringBuffer.length()-1);
			
			stringBuffer.append('1');
			printCode(hnode.right,stringBuffer);
			stringBuffer.deleteCharAt(stringBuffer.length()-1);	
		}
	
}

static HuffmanTree HuffmanBuild(int[] freqarr){
	PriorityQueue<HuffmanTree> pq=new PriorityQueue<HuffmanTree>();
	for(int i=0;i<freqarr.length;i++){
		if(freqarr[i]>0){
			pq.offer(new HuffmanLeaf(freqarr[i],(char)i));
		}}
		assert pq.size()>0;
		while(pq.size()>1){
		HuffmanTree a=pq.poll();
		HuffmanTree b=pq.poll();
		pq.offer(new HuffmanNode(a,b));
		}	
	return pq.poll();
}
}

class HuffmanTree implements Comparable<HuffmanTree>{

	int freq;
	HuffmanTree(int freq){
		this.freq=freq;
	}
	@Override
	public int compareTo(HuffmanTree o) {
		return this.freq-o.freq;
	}
}

class HuffmanLeaf extends HuffmanTree{
	char value;
	HuffmanLeaf(int freq,char val){
		super(freq);
		this.value=val;
	}
}

class HuffmanNode extends HuffmanTree{
HuffmanTree left,right;
HuffmanNode(HuffmanTree l,HuffmanTree r){
	super(l.freq+r.freq);
	this.left=l;
	this.right=r;
}	
}


