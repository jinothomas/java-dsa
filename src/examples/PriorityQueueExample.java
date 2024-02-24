package javabasics.datastructures.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javabasics.datastructures.PriorityQueue;

public class PriorityQueueExample {
	
	public static void main(String args[]) {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		Integer[] input = new Integer[8];
		
		input[0] = 12;
		input[1] = 4;
		input[2] = 5;
		input[3] = 23;
		input[4] = 656;
		input[5] = 4;
		input[6] = 3;
		input[7] = 5;
		PriorityQueue<Integer> arrayPQ = new PriorityQueue<>(input);
		
		List<Integer> listInput =  Arrays.asList(35,46,88,93,108,39,999,780,300,10,46);
		PriorityQueue<Integer> collectionPQ = new PriorityQueue<>(listInput);

		System.out.println(arrayPQ.toString());
		
		System.out.println(collectionPQ.toString());
		collectionPQ.removeAt(2);
		collectionPQ.remove(999);
		System.out.println(collectionPQ.toString());
	}

}
