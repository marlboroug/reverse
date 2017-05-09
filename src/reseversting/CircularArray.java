package reseversting;

import java.util.Iterator;

public class CircularArray <T> implements Iterable<T>{
		private T[] items;
		private int head = 0;
		public CircularArray(int size){
			items = (T[])new Object[size];
		}
		private int convert(int index){
			if (index < 0){
				index += items.length;
			}
			return (head + index) % items.length;
		}
		public void rotate(int shiftright){
			head = convert(shiftright);
		}
		public T get(int i){
			if (i < 0 || i >= items.length){
				throw new java.lang.IndexOutOfBoundsException("out of bound");
			}
			return items[convert(i)];
		}
		public void set(int i, T item){
			items[convert(i)] = item;
		}
		@Override
		public Iterator<T> iterator() {
			return new CircularArrayIterator<T>(this);
		}
		private class CircularArrayIterator<TI> implements Iterator<TI>{
			private int _current = -1;
			private TI[] _items;
			
			public CircularArrayIterator(CircularArray <TI> ite){
				_items = ite.items;
			}
			@Override
			public boolean hasNext() {
				return _current < _items.length - 1;
			}

			@Override
			public TI next() {
				_current ++;
				return _items[convert(_current)];
			}
			
		}
}
