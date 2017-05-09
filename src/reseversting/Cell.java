package reseversting;

public class Cell<K, V> {
	private K key;
	private V value;
	
	public  Cell(K key, V value){
		this.key = key;
		this.value = value;
	}
	public boolean isEqual(K k){
		return key.equals(k);
	}
	public boolean isEqual(Cell<K, V> c){
		return isEqual(c.getKey());
	}
	public K getKey(){
		return this.key;
	}
	public V getValue(){
		return this.value;
	}
}
