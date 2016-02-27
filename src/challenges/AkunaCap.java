package challenges;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class AkunaCap {
	public static void main(String[] args){
		System.out.println(bitCount(15));
		String a="Stringwithaaaaa";
		String b="Stringwithbbaaa";
		System.out.println(commonSort(a,b));
		int[] arr={2,10,45,123,123,432,9,132,123,93,7,8,8,};
		System.out.println("This "+largestProduct(arr));
		int[] ret=deleteDups(arr);
		for(int i:ret)
		{
			System.out.print(" "+i);
		}
	}
	
	
	private static int[] deleteDups(int[] arr) {
		mergeSort(arr,0,arr.length-1);
		for(int i:arr){
			System.out.println(i);
		}
		int prev=0;
		int i=0;
		while(i<arr.length){
			if(arr[prev]==arr[i]) {
				i++;
			} else {
				prev=prev+1;
				arr[prev]=arr[i];
				i++;
			}
		}
		int[] ret=new int[prev+1];
		for(int j=0;j<=prev;j++){
			ret[j]=arr[j];
		}
		return ret;
	}

	private static void mergeSort(int[] arr, int i, int j) {
		int mid;
		if(j>i){
			mid=(j+i)/2;
			mergeSort(arr,i,mid);
			mergeSort(arr,mid+1,j);
			merge(arr,i,mid,j);
		}
		
	}

	private static void merge(int[] combi, int i, int mid, int j) {
		int[] temp=new int[combi.length];
		for(int k=0;k<combi.length;k++){
			temp[k]=combi[k];
		}
		int index=i;
		int rind=mid+1;
		while(i<=mid&&rind<=j){
			if(temp[i]>temp[rind]){
				combi[index]=temp[i];
				i++;
				index++;
			}else if(temp[rind]>=temp[i]){
				combi[index]=temp[rind];
				rind++;
				index++;
			}
		}
		while(i<=mid){
			combi[index++]=temp[i++];
		}
		while(rind<=j){
			combi[index++]=temp[rind++];
		}
	}
	


	private static int largestProduct(int[] arr) {
		int max=Integer.MIN_VALUE;
		int maxProd=Integer.MIN_VALUE;
		int prod=0;
		int i=arr.length-1;
		while(i>=0){
			if(arr[i]>max){
				max=arr[i];
			}
			if(arr[i]!=max){
			prod=arr[i]*max;
			}
			if(prod>maxProd){
				maxProd=prod;
			}
			i--;
		}
		return maxProd;
		
	}


	private static String commonSort(String a, String b) {
		char[] fir=a.toCharArray();
		char[] sec=b.toCharArray();
		Arrays.sort(fir);
		Arrays.sort(sec);
		int i=0,j=0;
		int smallLen=fir.length<sec.length?fir.length:sec.length;
		ArrayList<Character> ret=new ArrayList<Character>();
		while(i<smallLen&&j<smallLen)
		{
			if(fir[i]==sec[j]){
				ret.add(fir[i]);
				i++;
				j++;	
			}
			else if(fir[i]>sec[j]){
				j++;
			}
			else if(sec[j]>fir[i]){
				i++;
			}
		}
		String retString="";
		for(char c:ret){
			retString=retString+c;
		}
		return retString;
	}


	static long bitCount(long number){
		long count=0;
		while(number>0){
			number=number & number-1;
			count=count+1;
		}
		return count;
		}
		
	}
	

