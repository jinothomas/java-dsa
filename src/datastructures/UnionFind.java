package javabasics.datastructures;

import java.security.InvalidParameterException;

public class UnionFind {
	
	private int size;
	
	private int[] component_size;
	
	private int[] component_id;
	
	private int no_component;
	
	public UnionFind(int size) {
		if(size<= 0) {
			throw new InvalidParameterException("Invalid size");
		}
		
		this.size = no_component = size;
		component_size = new int[size];
		component_id = new int[size];
	}
	
	public int find(int p) {
		int root = p;
		while (root != component_id[root]) {
			root = component_id[root];
		}

		while (p != root) {
			int next = component_id[p];
			component_id[p] = root;
			p = next;
		}

		return root;
	}
	
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int componentSize(int p) {
		return component_size[find(p)];
	}
	
	public int size() {
		return size;
	}
	
	public int components() {
		return no_component;
	}
 }
