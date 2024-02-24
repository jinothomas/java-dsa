package javabasics.datastructures;

import java.util.*;

public class PriorityQueue<T extends Comparable<T>>  {

	// The number of elements in the heap
	private int heapSize = 0;
	
	// The capacity of the heap
	private int heapCapacity = 0;
	
	// The dynamic element to keep the track elements inside heap
	private List<T> heap = null;
	
	private Map<T, TreeSet<Integer>> map = new HashMap<>();
	
	public PriorityQueue() {
		this(1);
	}
	
	public PriorityQueue(int size) {
		heap = new ArrayList<>(size);
	}
	
	public PriorityQueue(T[] elements) {
		heapSize = heapCapacity = elements.length;
		heap = new ArrayList<>(heapCapacity);

		for (int i = 0; i < heapSize; i++) {
			mapAdd(elements[i], i);
			heap.add(elements[i]);
		}
		for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
			sink(i);
		}
	}
	
	public PriorityQueue(Collection<T> elements) {
		this(elements.size());
		for(T element: elements) {
			add(element);     
		}
	}
	
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	public void clear() {
		for(int i =0 ; i< heapCapacity; i++) {
			heap.set(i, null);
		}
		heapSize = 0;
		map.clear();
	}
	
	public int size() {
		return heapSize;
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return heap.get(0);
	}
	
	public T poll() {
		return null;
	}
	
	
	public boolean contains(T element) {
		if(element == null) {
			return false;
		}
		return map.containsKey(element);
	}
	
	public void add(T element) {
		if(element == null) {
			throw new IllegalArgumentException();
		} 
		
		if(heapSize < heapCapacity) {
			heap.set(heapSize, element);
		}else {
			heap.add(element);
			heapCapacity++;
		}
		mapAdd(element, heapSize);
		swim(heapSize);
		heapSize++;
	}
	
	private boolean less(int i, int j) {
		T firstNode = heap.get(i);
		T secondNode = heap.get(j);
		
		return firstNode.compareTo(secondNode) <= 0;
	}
	
	// Bottom to top (up)
	private void swim(int k) {
		// reverse formula of finding next node (2i+1) 
		int parent = (k-1)/2;
		while(k>0 && less(k, parent)) {
			swap(parent, k);
			k = parent;
			parent = (k-1)/2;
		}
	}
	
	// Top to bottom (down)
	private void sink(int k) {
 		while (true) {
			int left = 2 * k + 1;
			int right = 2 * k + 2;
			int smallest = left;

			if (right < heapSize && less(right, left)) {
				smallest = right;
			}

			if (left >= heapSize || less(k, smallest)) {
				break;
			}
			swap(smallest, k);
			k = smallest;
		}
	}
	
	private void swap(int i, int j) {
		
		T element_i = heap.get(i);
		T element_j = heap.get(j);
		
		heap.set(i, element_j);
		heap.set(j, element_i);
		
		mapSwap(element_i, element_j, i, j);
	}
	
	public boolean remove(T element) {
		if (element == null) {
			return false;
		}

		Integer index = mapGet(element);
		if (index != null) {
			removeAt(index);
		}

		return index != null;
	}
	
	
	public T removeAt(int index) {
		if(isEmpty()) {
			return null;
		}
		heapSize--;
		T removed_data = heap.get(index);
		swap(index, heapSize);
		
		heap.set(heapSize, null);
		mapRemove(removed_data, heapSize);
		
		if(index == heapSize) {
			return removed_data;
		}
		T element = heap.get(index);
		sink(index);
		
		if(heap.get(index).equals(element)) {
			swim(index);
		}
		return null;
	}
	
	public boolean isMinHeap(int index) {
		if(index >= heapSize) {
			return true;
		}
		
		int left = 2 * index+ 1;
		int right = 2 * index + 2;
		
		if(left< heapSize && !less(index, left)){
			return false;
		}if(right< heapSize && !less(index,right)) {
			return false;
		}
		
		return isMinHeap(left) && isMinHeap(right);
	}
	
	
	private void mapAdd(T value, int index) {
		TreeSet<Integer> set =  map.get(value);
		
		if(set == null) {
			set = new TreeSet<>(); 
			set.add(index);
			map.put(value, set);
		}else {
			set.add(index);
		}
	}
	
	private void mapRemove(T value, int index) {
		TreeSet<Integer> set =  map.get(value);
		set.remove(index);
		if(set.size() == 0) {
			map.remove(value);
		}
	}
	
	private Integer mapGet(T value) {
		TreeSet<Integer> set = map.get(value);
		if (set != null) {
			return set.last();
		}

		return null;
	}
	
	private void mapSwap(T firstValue, T secondValue, int firstValueIndex, int secondValueIndex) {
		Set<Integer> firstSet = map.get(firstValue);
		Set<Integer> secondSet = map.get(secondValue);
		
		firstSet.remove(firstValueIndex);
		secondSet.remove(secondValueIndex);
		
		firstSet.add(secondValueIndex);
		secondSet.add(firstValueIndex);
	}
	
	@Override
	public String toString() {
		return heap.toString();
	}
}




