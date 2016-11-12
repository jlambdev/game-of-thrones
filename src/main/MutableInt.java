package main;

/**
 * Represents a Mutable Int, optimised for HashMaps
 * http://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
 */
public class MutableInt {
    private int value = 1; // note that we start at 1 since we're counting
    public void increment() { ++value; }
    public void decrement() { --value; }
    public int get() { return value; }
}
