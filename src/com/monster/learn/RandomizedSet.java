package com.monster.learn;

import java.util.HashSet;
import java.util.Random;

//20.73%
public class RandomizedSet {
    private HashSet<Integer> container;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        container = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return container.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       return container.remove(val); 
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = container.size();
        Random r = new Random();
        Object[] arr = container.toArray(); 
        return (int)arr[r.nextInt(size)];
    }
}