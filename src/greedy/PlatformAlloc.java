package greedy;

import java.util.PriorityQueue;

public class PlatformAlloc {

	public static void main(String args[]){
		int[] arri={945,1045,1030,915};
		int[] dept={930,1145,1100,1300};
		PriorityQueue<Time> pq=new PriorityQueue<Time>();
		for(int i:arri){
		pq.add(new Time(i,1));	
		}
		for(int d:dept){
		pq.add(new Time(d,2));	
		}
		Time[] time=new Time[pq.size()];
		pq.toArray(time);
		for(Time t:time){
			if(t.type==1){
				t.value=1;
			}else if(t.type==2){
				t.value=-1;
			}
		}
		
		for(int pos=1;pos<time.length;pos++){
			time[pos].value=time[pos-1].value+time[pos].value;
		}
		for(Time t:time){
			System.out.println(t.value);
		}
	}

	private static void MergeSort(int[] combi, int i, int j) {
		int mid;
		if(j>i){
			mid=(j+i)/2;
			MergeSort(combi,i,mid);
			MergeSort(combi,mid+1,j);
			Merge(combi,i,mid,j);
		}
		
	}

	private static void Merge(int[] combi, int i, int mid, int j) {
		int[] temp=new int[combi.length];
		for(int k=0;k<combi.length;k++){
			temp[k]=combi[k];
		}
		int index=i;
		int rind=mid+1;
		while(i<=mid&&rind<=j){
			if(temp[i]<=temp[rind]){
				combi[index]=temp[i];
				i++;
				index++;
			}else if(temp[rind]<temp[i]){
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
	
}

class Time implements Comparable<Time>{
	int value;
	int type;
	Time(int value,int type){
		this.value=value;
		this.type=type;
	}
	@Override
	public int compareTo(Time o) {
		return this.value-o.value;
	}
	
}
