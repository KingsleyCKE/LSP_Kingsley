// IntegerSet.java

package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();

	public IntegerSet() {
	}

	public void clear() {
		set.clear();
	}

	public int length() {
		return set.size();
	}

	public boolean equals(IntegerSet b) {
		return set.containsAll(b.set) && b.set.containsAll(set);
	}

	public boolean contains(int value) {
		return set.contains(value);
	}

	public int largest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("Set is empty");
		}
		int largest = set.get(0);
		for (int value : set) {
			if (value > largest) {
				largest = value;
			}
		}
		return largest;
	}

	public int smallest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("Set is empty");
		}
		int smallest = set.get(0);
		for (int value : set) {
			if (value < smallest) {
				smallest = value;
			}
		}
		return smallest;
	}

	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}

	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	}

	public void union(IntegerSet intSetb) {
		for (int value : intSetb.set) {
			if (!set.contains(value)) {
				set.add(value);
			}
		}
	}

	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}

	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}

	public boolean isEmpty() {
		return set.isEmpty();
	}

	public String toString() {
		return set.toString();
	}
}
