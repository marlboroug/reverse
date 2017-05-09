package reseversting;

import java.util.LinkedList;


public class MyHashMap<K, V> {
	private final int MAX_SIZE = 100;
	private LinkedList<Cell<K, V>>[] items;
	
	public MyHashMap(){
		items = (LinkedList<Cell<K, V>>[])new LinkedList[MAX_SIZE];
	}
	public int getIndex(K k){
		return k.toString().length() % items.length;	
	}
	public void put(K k, V v){
		int index = getIndex(k);
		if (items[index] == null){
			items[index] = new LinkedList<Cell<K, V>>();
		}
		LinkedList<Cell<K, V>> temp = items[index];
		Cell data = new Cell(k, v);
		for (Cell c : temp){
			if (c.isEqual(data)){
				temp.remove(c);
			}
		}
		temp.add(data);
	}
	public V get(K key){
		int index = getIndex(key);
		if (null == items[index]){
			return null;
		}
		LinkedList<Cell<K, V>> temp = items[index];
		for (Cell c : temp){
			if (c.getKey().equals(key)){
				return (V) c.getValue();
			}
		}
		return null;
	}
}
