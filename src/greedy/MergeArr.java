package greedy;

import java.util.*;
public class MergeArr {

	public static void main(String[] args){
	int[] arr={10,5,100,15,20,50};
	PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	for(int i=0;i<arr.length;i++){
		pq.add(arr[i]);
	}
	int megasum=0;
	while(pq.size()>1){
		int a=pq.remove();
		int b=pq.remove();
		int sum=a+b;
		megasum+=sum;
		System.out.println(a+" "+b+" "+megasum);
		pq.add(sum);
	}
	System.out.println(megasum);
	}
	
}
