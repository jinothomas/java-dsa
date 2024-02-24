package javabasics.datastructures;

import java.util.Iterator;

@SuppressWarnings("hiding")
public class SinglyLinkedList<T> implements Iterable<T> {

	private int size = 0;
	Node<T> head = null;
	Node<T> tail = null;
	
	private class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	// Clears list
	public void clear() {
		Node<T> trav = head;
		while(trav!=null) {
			Node<T> next = trav.next;
			trav.data = null;
			trav = next;
		}
		head = tail = null;
		size--;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() ==0;
	}
	
	public void add(T element) {
		addLast(element);
	}
	
	public void addLast(T element) {
		if (isEmpty()) {
			head = tail = new Node<T>(element);
		} else {
			tail.next = new Node<T>(element);
			tail = tail.next;
		}
		size++;
	}
	
	public void addFirst(T element) {
		if (isEmpty()) {
			head = tail = new Node<T>(element);
		} else {
			head.next = new Node<T>(element);
			head = head.next;
		}
		size++;
	}
	
	public T peekFirst() {
		return head.data;
	}
	
	public T peekLast() {
		return tail.data;
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Empty list");
		}
		T data = head.data;
		head = head.next;
		if (isEmpty()) {
			tail = null;
		}
		size--;
		return data;
	}
	
	public T remove(Node<T> node) {
		if(node.next == null) {
			removeFirst();
		}
		T data = node.data;
		node = node.next;
		if(isEmpty()) {
			tail = null;
		}
		size--;
		return data;
	}
	
	public T removeAt(int index) {
		if(index<0 || index >= size) {
			throw new IllegalArgumentException("Invali index");
		}
		int i =0;
		Node<T> trav;
		for(i = 0, trav = head; i!= index; i++) {
			trav = trav.next;
		}
		return remove(trav);
	}
	
	public T get(int index) {
		if(index<0 || index >= size) {
			throw new IllegalArgumentException("Invali index");
		}
		int i =0;
		Node<T> trav = head;
		while(trav!=null && i!=index) {
			trav = trav.next;
		}
		return trav.data;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
