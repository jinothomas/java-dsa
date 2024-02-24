package javabasics.datastructures.examples;

import java.util.Iterator;

import javabasics.datastructures.Queue;

public class QueueExample {
	
	public static void main(String args[]) {
		Queue<Integer> queue = new Queue<>(23);
		
		queue.offer(34);
		queue.offer(32);
		queue.offer(334);
		queue.offer(44);
		
		System.out.println(queue.peek());
		
		queue.poll();
		
		Iterator<Integer> itr = queue.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
