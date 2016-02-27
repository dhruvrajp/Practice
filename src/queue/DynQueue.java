package queue;

public class DynQueue {
public static void main(String[] args)
{
	int i=0;
	Queue q1=new Queue();
	q1.enqueue(5);
	q1.enqueue(4);
	q1.enqueue(10);
	q1.enqueue(3);
	q1.enqueue(14);
	while(i<q1.capacity)
	{
		System.out.println("Output "+q1.dequeue());
		i++;	
	}
}

}
