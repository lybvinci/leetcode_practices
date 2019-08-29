package com.monster.learn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//90.05%
public class NestedIterator implements Iterator<Integer> {
    private LinkedList<Integer> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        iter(nestedList);
    }

    private void iter(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger maybeInteger = nestedList.get(i);
            if (maybeInteger.isInteger()) {
                list.add(maybeInteger.getInteger());
            } else {
                iter(maybeInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return list.size() == 0;
    }
}