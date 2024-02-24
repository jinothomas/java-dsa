package javabasics.datastructures;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

	private T[] array;
	private int length = 0; // array length
	private int capacity = 0; // array capacity

	public DynamicArray() {
		this(16);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity:" + capacity);
		}
		this.capacity = capacity;
		array = (T[]) new Object[capacity];

	}

	// returns the size of the array
	public int size() {
		return length;
	}

	// checks the array is empty or not
	public boolean isEmpty() {
		return size() == 0;
	}

	// get specific element
	public T get(int index) {
		return array[index];
	}

	// set element to specific index
	public void set(int index, T element) {
		array[index] = element;
	}

	// clear all the elements
	public void clear() {
		for (int i = 0; i < length; i++) {
			array[i] = null;
		}
		length = 0;
	}

	// add new element, increase the size if capacity exceeds
	public void add(T element) {
		if (length + 1 >= capacity) {
			capacity = capacity == 0 ? 1 : capacity * 2;
			T[] new_array = (T[]) new Object[capacity]; // create new array with double capacity
			for (int i = 0; i < length; i++) {
				new_array[i] = array[i]; // Copy all the values
			}
			array = new_array; // replace array with newly created array
		}
		array[length++] = element;
	}
	
	// remove element at a specific location
	public T removeAt(int remove_index) {
		if (remove_index >= length || remove_index < 0) {
			throw new IndexOutOfBoundsException();
		}
		T data = array[remove_index];
		T[] new_array = (T[]) new Object[length - 1];
		for (int i = 0, j = 0; i < length; i++, j++) {
			if (i == remove_index) {
				j--;
			} else {
				new_array[j] = array[i];
			}
		}
		array = new_array;
		capacity = --length;
		return data;
	}
	
	// remove an element
	public boolean remove(Object element) {
		int index = indexOf(element);
		if (index == -1) {
			return false;
		}
		removeAt(index);
		return true;
	}

	// find the index of an element
	public int indexOf(Object element) {
		for (int i = 0; i < length; i++) {
			if (element == null) {
				if (array[i] == null) {
					return i;
				}
			} else {
				if (element.equals(array[i])) {
					return i;
				}
			}
		}

		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < length;
			}

			@Override
			public T next() {
				return array[index++];
			}
		};
	}
	
	@Override
	public String toString() {
		if (length == 0) {
			return "[]";
		} else {
			StringBuilder stringBuilder = new StringBuilder(length).append("[");
			for (int i = 0; i < length - 1; i++) {
				stringBuilder.append(array[i] + ", ");
			}
			return stringBuilder.append(array[length - 1] + "]").toString();
		}
	}

}
