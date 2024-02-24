package javabasics.datastructures.examples;

import java.util.Iterator;

import javabasics.datastructures.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(10);
		
		stack.push(12);
		stack.push(121);
		stack.push(23);
		stack.push(12);
		
		stack.pop();
		
		System.out.println(stack.peek());
		
		Iterator<Integer> itr = stack.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
