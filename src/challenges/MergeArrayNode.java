package challenges;

public class MergeArrayNode implements Comparable<MergeArrayNode>{

public int[] arr;
public int index;
	
public MergeArrayNode(int[] is, int i) {
	arr=is;
	index=i;
}

@Override
public int compareTo(MergeArrayNode o) {
	if(this.arr[this.index]>o.arr[o.index])
	{
	return 1;	
	}
	else if(this.arr[this.index]<o.arr[o.index])
	{
	return -1;
	}
	return 0;
}


}
