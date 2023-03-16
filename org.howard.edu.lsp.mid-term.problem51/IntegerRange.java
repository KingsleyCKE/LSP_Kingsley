package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
    private int lower;
    private int upper;

    IntegerRange(int lower, int upper) { // Constructor
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public boolean contains(int value) {
        return value >= lower && value <= upper;
    }

    public boolean overlaps(Range other) throws EmptyRangeException {
        if (other == null) {
            throw new EmptyRangeException("Empty Range");
        }
        return other.contains(lower) || other.contains(upper) || contains(((IntegerRange) other).getLower()) || contains(((IntegerRange) other).getUpper());
    }

    public int size() {
        return upper - lower + 1;
    }
}
