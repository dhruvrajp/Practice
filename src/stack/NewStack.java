package stack;

import java.util.*;

public class NewStack {
int capacity;
int[] arr;
int top;
int bottom;
NewStack(int capacity){
this.capacity=capacity;
arr=new int[capacity];
top=-1;
bottom=0;
}

public boolean push(int data){
	if(overflow())
	{
		return false;
	}
	else
		arr[++top]=data;
		return true;
}

public boolean overflow() {
	return top==capacity-1;
}
	
public int pop() throws Exception{
	if(!underflow()){
		int pop=arr[top--];
		return pop;
	}else
	{
		throw new Exception("Stack Empty");
	}
}

public boolean underflow() {
	// TODO Auto-generated method stub
	return top==-1;
}

public int getTop(){
	return top;
}

public int removeBottom(){
	int bot=arr[bottom];
	for(int i=top-1;i>=bottom;i--){
		arr[i]=arr[i+1];
	}
	top=top-1;
	return bot;
}
}
