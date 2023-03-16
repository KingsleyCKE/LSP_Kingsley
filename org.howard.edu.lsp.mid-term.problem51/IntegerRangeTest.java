package org.howard.edu.lsp.midterm.problem51;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRangeTest {
    @Test
    void testContains() {
        IntegerRange range = new IntegerRange(1, 10);
        assertTrue(range.contains(5));
        assertFalse(range.contains(11));
    }

    @Test
    void testOverlaps() throws EmptyRangeException {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(11, 20);

        assertTrue(range1.overlaps(range2));
        assertFalse(range1.overlaps(range3));

        assertThrows(EmptyRangeException.class, () -> range1.overlaps(null));
    }

    @Test
    void testSize() {
        IntegerRange range = new IntegerRange(1, 10);
        assertEquals(10, range.size());
    }
}
