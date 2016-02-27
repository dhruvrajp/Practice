package ctcode;

public class Employee {
public int rank;
String name;
int diff;
boolean free;
Employee(String name,int n,int diff){
	this.name=name;
	this.rank=n;
	this.diff=diff;
	this.free=true;
}

public void changeStatus(boolean s){
	this.free=s;
}

public boolean handleCall(Call c){
	if(c.diff>this.diff){
		return false;
	}
	changeStatus(false);
	return true;
}
}

class Fresher extends Employee{
	Fresher(String s){
	super(s,0,1);
	}
}


class TeamLead extends Employee{
	TeamLead(String s){
	super(s,0,2);
	}
}

class ProjManager extends Employee{
	ProjManager(String s){
	super(s,0,2);
	}
}