package javabasics.datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

	LinkedList<T> list = new LinkedList<>();

	public Stack() {}

	public Stack(T firstElement) {	
		push(firstElement);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(T element) {
		list.addLast(element);
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeLast();
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return list.peekLast();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

}
