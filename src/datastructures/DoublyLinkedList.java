package javabasics.datastructures;

import java.util.Iterator;

@SuppressWarnings("hiding")
public class DoublyLinkedList<T> implements Iterable<T> {
	
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	private class Node<T> {
		private T data;
		private Node<T> next, prev;
		
		public Node(T data, Node<T> prev,Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	// clears linkedlist
	public void clear() {
		Node<T> trav = head;
		while (trav != null) {
			Node<T> next = trav.next;
			trav.next = trav.prev = null;
			trav.data = null;
			trav = next;
		}
		head = tail = trav = null;
		size = 0;
	}
	
	// returns the size
	public int size() {
		return size;
	}
	
	// checks empty or not
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//add Element to the list
	public void add(T element) {
		addLast(element);
	}
	
	// add element to the last position of the list
	public void addLast(T element) {
		if(isEmpty()) {
			head = tail = new Node<T>(element, null, null);
		}else {
			tail.next = new Node<T>(element, tail, null);
			tail = tail.next;
		}
		size++;
	}
	
	// add element to the first position of the list
	public void addFirst(T element) {
		if(isEmpty()) {
			head = tail = new Node<T>(element, null, head);
		}else {
			head.prev = new Node<T>(element, null, head);
			head = head.prev;
		}
		size++;
		
	}
	
	// get the first element
	public T peekFirst() {
		if(isEmpty()) {
			throw new RuntimeException("Empty list");
		}else {
			return head.data;
		}
	}
	
	// get the last element
	public T peekLast() {
		if(isEmpty()) {
			throw new RuntimeException("Empty list");
		}else {
			return tail.data;
		}
	}
	
	public T removeFirst() {
		if(isEmpty()) {
			throw new RuntimeException("Empty list");
		}
		T data = head.data;
		head = head.next;
		size--;
		
		if(isEmpty()) {
			tail = null;
		}else {
			head.prev = null;
		}
		return data;
	}
	
	public T removeLast() {
		if(isEmpty()) {
			throw new RuntimeException("Empty list");
		}
		T data = tail.data;
		tail = tail.prev;
		size--;
		
		if(isEmpty()) {
			head = null;
		}else {
			tail.next = null;
		}
		return data;
	}
	
	public T remove(Node<T> node) {
		if(node.prev == null) {
			removeFirst();
		}
		if(node.next == null) {
			removeLast();
		}
		
		node.next.prev = node.prev;
		node.prev.next = node.next;
		
		T data = node.data;
		
		node.data = null;
		node = node.prev = node.next = null;
		
		size--;
		return data;
	}
	
	
	
	public T removeAt(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid Index");
		}
		
		int i;
		Node<T> trav;
		if(index <= size/2) {
			for(i = 0, trav = head; i!= index; i++) {
				trav = trav.next;
			}
		}else {
			for(i=size-1, trav = tail; i!= index; i--) {
				trav = trav.prev;
			}
		}
		
		return remove(trav);
	}
	
	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid Index");
		}
		
		int i;
		Node<T> trav;
		if(index <= size/2) {
			for(i = 0, trav = head; i!= index; i++) {
				trav = trav.next;
			}
		}else {
			for(i=size-1, trav = tail; i!= index; i--) {
				trav = trav.prev;
			}
		}
		
		return trav.data;
	}
	
	public boolean remove(Object element) {
		Node<T> trav = head;
		
		for(trav = head; trav != null; trav = trav.next ) {
			if((element!= null && element.equals(trav.data)) || (element == null && trav.data == null)) {
				remove(trav);
				return true;
			}
				
		}
		
		return false;
	}
	
	
	public int indexOf(Object element) {
		int index = 0;
		Node<T> trav = head;
		
		for(trav = trav.next; trav!=null; index ++) {
			if((element!= null && element.equals(trav.data)) || (element == null && trav.data == null)) {
				return index;
			}
		}
		
		return -1;
	}
	
	public boolean contains(Object element) {
		return indexOf(element) != -1;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
