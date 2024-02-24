package javabasics.datastructures.examples;

import javabasics.datastructures.DynamicArray;

public class DyanamicArrayExample {
	
	public static void main(String args[]) {
		DynamicArray<Integer> d_array =  new DynamicArray<>();
		d_array.add(10);
		d_array.add(13);
		d_array.add(23);
		d_array.add(4);
		d_array.add(4);
		System.out.println(d_array.toString());
		d_array.remove(4);
		System.out.println(d_array.toString());
		
		d_array.removeAt(3);
		System.out.println(d_array.toString());
		
		System.out.println(d_array.get(0));
		d_array.set(0, 34);
		System.out.println(d_array.toString());
		
		for(int i = 0; i< 100 ; i++) {
			d_array.add(i);
		}
		
		System.out.println(d_array.toString());
	}
	
	
	
}
