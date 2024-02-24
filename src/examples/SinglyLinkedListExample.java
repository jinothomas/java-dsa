package javabasics.datastructures.examples;

import javabasics.datastructures.SinglyLinkedList;

public class SinglyLinkedListExample {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> singlyList = new SinglyLinkedList<>();
		
		singlyList.add(10);
		singlyList.add(14);
		singlyList.add(16);
		singlyList.add(35);
		singlyList.add(31);
		singlyList.add(99);
		
		singlyList.addFirst(102);
		singlyList.addLast(1323);
		
		for(int i =0; i< singlyList.size(); i++) {
			System.out.println(singlyList.get(i));
		}

	}

}
