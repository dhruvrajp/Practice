package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IntervalScheduling {

	public static void main(String[] args){
		Job[] j=new Job[7];
		j[0]=new Job('a',0,5);
		j[1]=new Job('b',2,7);
		j[2]=new Job('c',5,8);
		j[3]=new Job('d',5,7);
		j[4]=new Job('e',6,10);
		j[5]=new Job('f',7,10);
		j[6]=new Job('g',4,8);
		ArrayList<Job> ret=scheduleJob(j);
		for(Job retJ:ret){
			System.out.println(retJ.id);
		}
		
		}

	private static ArrayList<Job> scheduleJob(Job[] j) {
		PriorityQueue<Job> pq=new PriorityQueue<Job>();
		for(Job job:j){
			pq.add(job);
		}
		Job first=pq.poll();
		int last=first.finish;
		ArrayList<Job> al=new ArrayList<Job>();
		al.add(first);
		while(!pq.isEmpty()){
			Job jret=pq.poll();
			if(jret.start>=last){
				last=jret.finish;
				al.add(jret);
			}
			}
		return al;
		}

}
class Job implements Comparable<Job>{
	char id;
	int start;
	int finish;
	Job(char c,int start,int finish){
		id=c;
		this.start=start;
		this.finish=finish;
	}
	
	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		return this.finish-o.finish;
	}
	
}