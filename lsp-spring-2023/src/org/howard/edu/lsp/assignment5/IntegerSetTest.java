package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.howard.edu.lsp.assignment5.IntegerSet;
import org.howard.edu.lsp.assignment5.IntegerSetException;

public class IntegerSetTest {

  private IntegerSet set1;
  private IntegerSet set2;

  @BeforeEach
  public void setUp() {
    set1 = new IntegerSet();
    set2 = new IntegerSet();
  }

  @Test
  @DisplayName("Test case for clear")
  public void testClear() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set1.clear();
    assertEquals(0, set1.length(), "Clear method failed");
  }

  @Test
  @DisplayName("Test case for length")
  public void testLength() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    assertEquals(3, set1.length(), "Length method failed");
  }

  @Test
  @DisplayName("Test case for equals")
  public void testEquals() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set2.add(3);
    set2.add(1);
    set2.add(2);
    assertTrue(set1.equals(set2), "Equals method failed");
  }

  @Test
  @DisplayName("Test case for contains")
  public void testContains() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    assertTrue(set1.contains(2), "Contains method failed");
    assertFalse(set1.contains(4), "Contains method failed");
  }

  @Test
  @DisplayName("Test case for largest")
  public void testLargest() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    try {
      assertEquals(3, set1.largest(), "Largest method failed");
    } catch (IntegerSetException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test case for smallest")
  public void testSmallest() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    try {
      assertEquals(1, set1.smallest(), "Smallest method failed");
    } catch (IntegerSetException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test case for add")
  public void testAdd() {
    set1.add(1);
    assertTrue(set1.contains(1), "Add method failed");
  }

  @Test
  @DisplayName("Test case for remove")
  public void testRemove() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set1.remove(2);
    assertFalse(set1.contains(2), "Remove method failed");
  }

  @Test
  @DisplayName("Test case for union")
  public void testUnion() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set2.add(4);
    set2.add(5);
    set1.union(set2);
    assertTrue(set1.contains(1) && set1.contains(2) && set1.contains(3) && set1.contains(4) && set1.contains(5), "Union method failed");
  }

  @Test
  @DisplayName("Test case for intersect")
  public void testIntersect() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set2.add(2);
    set2.add(3);
    set2.add(4);
    set1.intersect(set2);
    assertTrue(set1.contains(2) && set1.contains(3) && !set1.contains(1) && !set1.contains(4), "Intersect method failed");
  }

  @Test
  @DisplayName("Test case for diff")
  public void testDiff() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    set2.add(2);
    set2.add(3);
    set2.add(4);
    set1.diff(set2);
    assertTrue(set1.contains(1) && !set1.contains(2) && !set1.contains(3) && !set1.contains(4), "Diff method failed");
  }

  @Test
  @DisplayName("Test case for isEmpty")
  public void testIsEmpty() {
    assertTrue(set1.isEmpty(), "IsEmpty method failed for empty set");
    set1.add(1);
    set1.add(2);
    set1.add(3);
    assertFalse(set1.isEmpty(), "IsEmpty method failed for non-empty set");
  }

  @Test
  @DisplayName("Test case for toString")
  public void testToString() {
    set1.add(1);
    set1.add(2);
    set1.add(3);
    assertEquals("[1, 2, 3]", set1.toString(), "ToString method failed");
  }
}

