package stack;

import java.util.*;

public class SetOfStacks {
ArrayList<NewStack> set=new ArrayList<NewStack>();
int capacity;
SetOfStacks(int cap){
	this.capacity=cap;
}
public void push(int data){
	NewStack last=getLastStack();
	if(last!=null&&!last.overflow()){
		last.push(data);
	}
	else{
	NewStack stack=new NewStack(capacity);	
	stack.push(data);
	set.add(stack);
	}
}
private NewStack getLastStack() {
	if(set.size()==0){
		return null;
	}
	else{
		return set.get(set.size()-1);
	}
}

public int pop() throws Exception{
	if(set.size()==0)
		throw new Exception("All Stacks Empty");
	if(set.get(set.size()-1).underflow())
		set.remove(set.size()-1);
	return set.get(set.size()-1).pop();
}

public int popAt(int index) throws Exception{
	NewStack indStack = set.get(index);
	int ret;
	if(!indStack.underflow()){
	ret=indStack.pop();
	}
	else{
		throw new Exception("Requested Stack is Empty");
	}
	if(index!=set.size()-1){
		shiftLeft(index);
	}
	return ret;
}
private void shiftLeft(int index) {
	NewStack last=set.get(index);
	if(last.underflow()){
		set.remove(index);
	}
	else{
		last.push(set.get(index+1).removeBottom());
		shiftLeft(index+1);
	}
	if(index==set.size()){
		return;
	}
}
}
