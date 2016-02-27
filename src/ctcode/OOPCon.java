package ctcode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class OOPCon {
	public static void main(String[] args){
		CallCenter c=new CallCenter(10);
		Fresher f1=new Fresher("A");
		Fresher f2=new Fresher("b");
		Fresher f3=new Fresher("c");
		TeamLead f4=new TeamLead("d");
		Fresher f5=new Fresher("e");
		ProjManager f6=new ProjManager("f");
		c.addEmployee(f1);
		c.addEmployee(f2);
		c.addEmployee(f3);
		c.addEmployee(f4);
		c.addEmployee(f5);
		c.addEmployee(f6);
		Call c1=new Call(1);
		Call c2=new Call(2);
		Call c3=new Call(2);
		System.out.println(c.getCallHandler(c1).name);
		System.out.println(c.getCallHandler(c2).name);
		System.out.println(c.getCallHandler(c3).name);
		
	}
}



class CallCenter{
	static final int LEVEL=3;
	int numOfFresher;
	ArrayList<Employee>[] empList=new ArrayList[LEVEL];
	Queue<Call> call=new java.util.LinkedList<Call>(); 
	CallCenter(int n){
		this.numOfFresher=n;
		for(int i=0;i<LEVEL;i++){
			empList[i]=new ArrayList<Employee>();
		}
	}
	public void addEmployee(Employee e){
		empList[e.rank].add(e);
	}
	public Employee getCallHandler(Call c){
		int i=0;
		while(i<LEVEL){
			for(Employee e:empList[i]){
				if(e.free){
					if(e.handleCall(c)){
						return e;
					}
					else{
						i=i+1;
					}
				}
			}
			i=i+1;
		}
		return null;
	}
	
	public void handleNext(Employee e){
		
	}
	
}

