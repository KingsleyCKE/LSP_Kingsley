package org.howard.edu.lsp.assignment5;

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
      throw new IntegerSetException("The set is empty");
    }
    return set.stream().max(Integer::compare).get();
  }

  public int smallest() throws IntegerSetException {
    if (set.isEmpty()) {
      throw new IntegerSetException("The set is empty");
    }
    return set.stream().min(Integer::compare).get();
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
    for (int item : intSetb.set) {
      add(item);
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