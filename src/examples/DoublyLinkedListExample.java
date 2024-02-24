package javabasics.datastructures.examples;

import javabasics.datastructures.DoublyLinkedList;

public class DoublyLinkedListExample {

	
	public static void main(String args[]) {
		
		DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
		
		doublyList.add(10);
		doublyList.add(23);
		doublyList.add(34);
		doublyList.add(99);
		doublyList.add(23);
		doublyList.add(90);
		
		doublyList.addFirst(100);
		doublyList.addLast(1023);
		
		doublyList.remove(10);
		
		for(int i =0; i< doublyList.size(); i++) {
			System.out.println(doublyList.get(i));
		}
	}
	
}
