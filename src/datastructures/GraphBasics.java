package javabasics;

import java.util.*;

public class GraphBasics<T> {
	
	private Map<T,List<T>> map = new HashMap<>();
	
	
	public void addVertex(T vertex) {
		map.put(vertex, new LinkedList<>());
	}

	public static void main(String args[]) {
		
	}
}
