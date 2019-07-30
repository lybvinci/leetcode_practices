package com.monster.learn;

import java.util.Iterator;
import java.util.LinkedList;

//90.24%
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> queue;
    private Integer peek = null;
	public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        queue = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (null == peek) {
            peek = queue.next();
        }
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (null != peek) {
            Integer res = peek;
            peek = null;
            return res;
        } else {
            return queue.next();
        }
	}

	@Override
	public boolean hasNext() {
        return peek != null || queue.hasNext();
	}
}