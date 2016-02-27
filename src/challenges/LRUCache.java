package challenges;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>{

	int siz;
	LRUCache(int cap){
		super(cap);
		siz=cap;
	}
	
	public int get(int key){
		if(this.containsKey(key)){
			int val=super.get(key);
			super.remove(key);
			super.put(key, val);
			return val;
		}else{
			return -1;
		}
	}
	
	public void set(int key,int val){
		if(this.containsKey(key)){
			super.remove(key);
			super.put(key, val);
		}else{
			super.put(key, val);
		}
	}
	
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
		return this.size()>=siz;
	}
    
	
	
	

	
}
