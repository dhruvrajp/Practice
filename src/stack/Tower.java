package stack;

import java.util.Stack;
public class Tower{
public static void main(String[] args){
	int n=7;
	HanoiTower[] tower=new HanoiTower[7];
	for(int i=0;i<3;i++)tower[i]=new HanoiTower(i);
	for(int i=n-1;i>=0;i--)tower[0].add(i);
	tower[0].move(n-1,tower[2],tower[1]);
}	
}

class HanoiTower{
Stack<Integer> disks;
int index;
HanoiTower(int index){
this.index=index;	
disks=new Stack<Integer>();	
}
	
public void add(int d){
if(!disks.isEmpty()&&disks.peek()<=d){
	System.out.println("Error loading");	
}else{
disks.push(d);	
}
}	

public void moveToTop(HanoiTower h){
	/*Pop last element from first disk and move to dest disk*/
	int t=disks.pop();
	h.add(t);
	System.out.println("Move "+t+"from "+index+"to "+h.index);
}

public void move(int index,HanoiTower dest,HanoiTower buffer){
	if(index>0){
		move(index-1,buffer,dest);
		moveToTop(dest);
		buffer.move(index-1,dest,this);
	}
	
	
}	
}