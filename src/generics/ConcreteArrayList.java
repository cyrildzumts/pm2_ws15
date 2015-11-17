/**
 * Konkrete Implementation vom AbstractList mit Hilfe von Array.
 * Als Übung man könnte Knoten anstatt ein Array nutzen.
 * 
 * Jemand könnte auch JUnit Test Case implementieren.
 */

package generics;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ConcreteArrayList<Item> implements AbstractList<Item>{

	private Item[] container;
	private int count;
	
	private static final int INDEX_LOWER_BOUND = 1; 
	private static int DEFAULT_CAPACITY = 20  + INDEX_LOWER_BOUND;
	
	
	
	public ConcreteArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	
	public ConcreteArrayList(int arraySize){
		count = 0;
		container = (Item[])new Object [arraySize + INDEX_LOWER_BOUND]; 
		System.out.println("ConcreteList created");
	}
	@Override
	public void insert(int pos, Item item) throws IndexOutOfBoundsException {
		
		/*
		 * 
		 */
//		if(pos + INDEX_LOWER_BOUND < INDEX_LOWER_BOUND){
//			throw new IndexOutOfBoundsException("Index " + pos + " is out of bound");
//		}
		checkIndex(pos + INDEX_LOWER_BOUND , count + 1 + INDEX_LOWER_BOUND);

		if(count == container.length){
			resize(container.length * 2);
		}
		for(int index = count ; index >= pos + INDEX_LOWER_BOUND; index--){
			container[index + 1] = container [index];
		}
		container[pos + INDEX_LOWER_BOUND] = item;
		count++;
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		checkIndex(pos + INDEX_LOWER_BOUND , count + 1 );
		for(int index = pos + INDEX_LOWER_BOUND; index < count ; index++){
			container[index ] = container[index + 1];
		}
		container[count] = null;
		count--;		
	}

	@Override
	public int find(Item item) {
		int i = count + 1;
		container[0] = item;
		while(container[i] != item){
			i--;
		}
		return (i -1);
	}

	@Override
	public Item retrieve(int pos) throws IndexOutOfBoundsException {
		checkIndex(pos + INDEX_LOWER_BOUND , count +1);
		return container[pos + INDEX_LOWER_BOUND];
	}

	@Override
	public AbstractList<Item> concat(AbstractList<Item> list) {
		Item[] tmp = (Item[])new Object [count + list.size()];
		for( int i = INDEX_LOWER_BOUND; i < count; i++){
			tmp[i] = container[i];
		}
		for( int i = INDEX_LOWER_BOUND; i < list.size(); i++){
			tmp[count + i] = list.retrieve(i);
		}
		container = tmp;
		count = count + list.size();
		return this;
	}

	@Override
	public int size() {
		
		return count;
	}

	protected void resize(int capacity) {
		Item[] tmp = (Item[])new Object [capacity];
		for(int index = 0; index < count; index++){
			tmp[index] = container[index];
		}
		container = tmp;
	}
	
	protected void checkIndex(int lowBound, int upperBound) throws IndexOutOfBoundsException  {
		if ((lowBound < INDEX_LOWER_BOUND)|| (lowBound >= upperBound)) {
			throw new IndexOutOfBoundsException("Index " + (lowBound - 1) + " is out of bound");
		}
	}


	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> it = new Iterator<Item>(){
			int currentIndex = INDEX_LOWER_BOUND;
			@Override
			public boolean hasNext() {
				return ( (currentIndex <= count) && (container[currentIndex] != null));
			}

			@Override
			public Item next() {
				return container[currentIndex++];
			}
			
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
			
		};
		return it;
	}
}
