package ctcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SortSearch {
	public static void main(String[] args){
		int[] a={1,5,6,10,12,14,0,0,0,0};
		int[] b={2,3,5,6};
		int k=a.length-1;
		int i=5;
		int j=b.length-1;
		while(j>=0&&i>=0){
			if(a[i]>b[j]){
				a[k--]=a[i--];
			}else{
				a[k--]=b[j--];
			}
		}
		for(int in:a){
			System.out.println(in);
		}
		String[] strarr={"bat","cat","abc","tab","tac","tca"};
		arrAnag(strarr);
		System.out.println("\n");
		for(String s:strarr){
			System.out.print(" "+s);
		}
	int[] arr2={101,12,16,27,34,41,51,61,71,81,91};
	System.out.println(findInd(arr2,16,0,arr2.length-1));
	int[][] mat1={{1,2,3,4},{21,31,41,51},{311,411,511,611},{4111,5111,6111,7111}};
	System.out.println(findMat(mat1,411));	
	String[] strar2={"","","cat","","bat","","sda","asda",""};
	System.out.println("Check: "+checkFor(strar2,"sda"));
	ArrayList<circItem> circ=new ArrayList<circItem>();
	circItem c1=new circItem(45,50);
	circItem c2=new circItem(85,90);
	circItem c3=new circItem(55,60);
	circItem c4=new circItem(105,110);
	circItem c5=new circItem(25,150);
	circItem c6=new circItem(75,75);
	circItem c7=new circItem(80,82);
	circArrange(circ);
	}

	private static int checkFor(String[] strar2, String string) {
		int s=0,l=strar2.length-1;
		while(s<l){
			while(s<l&&strar2[l]!=""){
				l--;
			}
			if(l<s){
				return -1;
			}
			int mid=(s+l)/2;
			int comp=strar2[mid].compareTo(string);
			if(comp==0)
				return mid;
			else if(comp>1){
				s=mid+1;
			}else
			{
				l=mid-1;
			}
		}
		return -1;
	}

	private static void circArrange(ArrayList<circItem> circ) {
		
	
		
	}

	private static String findMat(int[][] mat, int i) {
		int row=0;
		int col=mat.length-1;
		while(row<mat.length-1 && col>=0){
			if(mat[row][col]==i){
				return ""+row+" "+col;
			}else if (mat[row][col]>i){
				col--;
			}else{
				row++;
			}
		}
		return "Not Found";
	}

	private static int findInd(int[] a, int i,int l,int u) {
		while(l<=u){
			int mid=(l+u)/2;
			if(a[mid]==i)
				return mid;
			else if(a[l]<=a[mid]){
				if(i>a[mid]){
					l=mid+1;
				}else if(i>=a[l]){
					u=mid-1;
				}else{
					l=mid+1;
				}
			}
			else if(i<a[mid]){
				u=mid-1;
			}else if(i<=a[u]){
				l=mid+1;	
			}else u=mid-1;
		}
		return -1;
				
	}

	private static void arrAnag(String[] strarr) {
		Arrays.sort(strarr,new AnagComp());
	
	}
	
}

class AnagComp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return sortChars(o1).compareTo(sortChars(o2));
	}

	private String sortChars(String o2) {
		char[] ch=o2.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}


class circItem{
	int weight;
	int height;
	circItem(int w,int h){
	this.weight=w;
	this.height=h;
	}
}


