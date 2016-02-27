package stack;


public class StackArrayTest{
	public static void main(String[] args) throws Exception{
		StackArray sa1=new StackArray();
		sa1.pushStackOne(4);
		sa1.pushStackOne(3);
		sa1.pushStackTwo(7);
		sa1.pushStackTwo(8);
		sa1.pushStackTwo(12);
		sa1.pushStackThree(9);
		sa1.pushStackThree(10);
		sa1.pushStackOne(37);
		sa1.pushStackOne(26);
		sa1.pushStackTwo(8);
	}
}

class StackArray {
int [] stackArray=new int[10];
int top1=-1,top2=stackArray.length,top3=stackArray.length/2-1;
int base3=stackArray.length/2;

public boolean isLeftShiftable(){
if (top1+1==base3)
	return false;
else return true;
}

public boolean isRightShiftable(){
if (top3+1==top2)
	return false;
else return true;
}	
	
public void shiftRight()
{
for(int i=top3+1;i>=base3+1;i--){
stackArray[i]=stackArray[i-1];	
}
top3++;
base3++;	
}

public void shiftLeft(){
for(int i=base3-1;i<=top3-1;i++){
stackArray[i]=stackArray[i+1];	
}
top3--;
base3--;	
}

public void pushStackOne(int d) throws Exception{
	if(top1+1==base3){
		if(isRightShiftable())
		{
			shiftRight();
			stackArray[++top1]=d;
		}else throw new Exception("Stack 1 is full and Stack 3 cannot be shifted");
	}else stackArray[++top1]=d;
}

public void pushStackTwo(int d) throws Exception{
	if(top2-1==top3){
		if(isLeftShiftable())
		{
			shiftLeft();
			stackArray[--top2]=d;
		}else throw new Exception("Stack 2 is full and Stack 3 cannot be shifted");
	}else stackArray[--top2]=d;
}

public void pushStackThree(int d) throws Exception{
	if(top3+1==top2){
		if(isLeftShiftable())
		{
			shiftLeft();
			stackArray[++top3]=d;
		}else throw new Exception("Stack 3 is full");
	}else stackArray[++top3]=d;
}


public int pop(int id) throws Exception{
	switch(id){
		case 1:
			int ret1=top1;
			top1--;
			return ret1;
		case 2:
			int ret2=top2;
			top2++;
			return ret2;
		case 3:
			int ret3=top3;
			top3--;
			return ret3;
		default:
		throw new Exception("Invalid Stack Number");
	}
	
}

}
