package greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FractKnapSack {

	public static void main(String[] args){
		int[] weight={6,5,1,45,2,9};
		int[] value={24,15,42,90,18,9};
		Item[] items=new Item[weight.length];
		PriorityQueue<Item> pq=new PriorityQueue<Item>();
		for(int i=0;i<items.length;i++){
			items[i]=new Item(weight[i],value[i],i);
			pq.add(items[i]);
		}
		int cap=4;
		for(int j=0;j<cap;j++){
			Item i=pq.poll();
			System.out.println(i.index+" "+i.density);
		}
		
	}
	
	static int[] HeapSort(int[] array){
		Heap h1=new Heap(array);
		int[] newArray=new int[array.length];
		for(int i=0;i<newArray.length;i++){
			newArray[i]=h1.delete();
		}
		return newArray;
	}
}


class Item implements Comparable<Item>{
	int weight;
	int index;
	int value;
	int density;
	Item(int w,int v,int index){
		this.weight=w;
		this.value=v;
		this.index=index;
		density=v/w;
	}
	@Override
	public int compareTo(Item o) {
		return o.density-this.density;
	}
	
	
}

class Heap{
	int[] array;
	int count;
	Heap(int[] array){
		this.array=array;
		this.count=array.length;
		buildHeap(array);
	}
	private void buildHeap(int[] array2) {
		if(array.length==0)
			return;
		for(int i=(count-1)/2;i>=0;i--){
			heapify(i);
		}
	}
	private void heapify(int i) {
		if(i<0||i>count)
			return;
		int left=(2*i)+1;
		int right=(2*i)+2;
		int max=i;
		if(left<=(count-1)&&array[left]>array[i]){
			max=left;
		}
		else{
			max=i;
		}
		if(right<=(count-1)&&array[right]>array[max]){
			max=right;
		}
		if(max!=i){
			int temp=array[max];
			array[max]=array[i];
			array[i]=temp;
			heapify(max);
		}
	}

	public int delete(){
		if (count==0){
		return array[count];}
		int i=count-1;
		int temp=array[i];
		int ret=array[0];
		array[0]=temp;
		count=count-1;
		heapify(0);
		return ret;
	}
}