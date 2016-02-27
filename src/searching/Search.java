package searching;

import java.util.*;
public class Search {

	public static void main(String[] args){
		int[] arr={6,3,2,1,2,2,3,3,1,4,5,6};
		firstRepeat(arr);
		int[] arr2={5,2,3,6,1,5,2,3,4,6,1,6};
		findMiss(arr2);
		findTarget(arr2,10);
		int[] a={-45,30,-24,-78,99,100};
		findClosestToZero(a);
		
	}
	
	private static void findClosestToZero(int[] a) {
		Arrays.sort(a);
		int i=0,j=a.length-1,min_l=-1,min_r=-1;
		int sum=Integer.MAX_VALUE;
		while(i<j)
		{
			int temp=a[i]+a[j];
			if(Math.abs(temp)<Math.abs(sum)){
				sum=temp;
				min_l=i;
				min_r=j;
			}
			if(temp>0){
				j--;
			}
			else
			{
				i++;
			}
		}
		System.out.println(a[min_l]+" "+a[min_r]+" "+sum);
	}

	private static void findTarget(int[] arr2, int target) {
		HashMap<Integer,Integer> hmp=new HashMap<Integer,Integer>();
		for(int i=0;i<arr2.length;i++){
			if(hmp.containsKey(target-arr2[i])){
				int t=target-arr2[i];
				System.out.println(" "+arr2[i]+" "+t);
			}
			else
			{
				hmp.put(arr2[i], arr2[i]);
			}
		}
		
	}


	private static void findMiss(int[] arr2) {
		int sum=(arr2.length+1)*(arr2.length+2)/2;
		System.out.println(sum);
		for(int i=0;i<arr2.length;i++){
			sum=sum-arr2[i];
		}
		System.out.println("SumMethod  "+sum);
	}

	private static void firstRepeat(int[] arr) {
		HashMap<Integer,Integer> hmp=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++){
			if(hmp.containsKey(arr[i])){
				if(hmp.get(arr[i])>0){
				hmp.put(arr[i],(hmp.get(arr[i])*-1));
				}
			}
			else{
			hmp.put(arr[i],i+1);
			}
		}
		int MAX=Integer.MIN_VALUE;
		int ret=-1;
		for(Map.Entry<Integer, Integer> me:hmp.entrySet()){
			if(me.getValue()>MAX&&me.getValue()<0){
				MAX=me.getValue();
				ret=me.getKey();
			}
		}
		System.out.println(ret);
		
	}
	
}
