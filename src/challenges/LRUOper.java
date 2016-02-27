package challenges;

public class LRUOper {
	public static void main(String[] args){
		LRUCache lrc=new LRUCache(5);
		lrc.set(5,15);
		lrc.set(4,11);
		lrc.set(3,13);
		lrc.set(2,12);
		lrc.set(1,19);
		lrc.get(5);
		lrc.set(6, 54);
		System.out.println(lrc.get(3));
		System.out.println(lrc.get(2));
		
		
		
	}
}
