package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//45.03%
public class CanReorderDoubled {
  public boolean canReorderDoubled(int[] A) {
    List<List<Integer>> allList = split(A);
        for(List<Integer> list: allList) {
            if(!process(list)) {
                //System.out.println("false: " + list.get(0) + ", " + list.get(1) + ", " + list.size());
                return false;
            }
        }
        return true;
  }

  public boolean process(List<Integer> list) {
    if(list.size() == 0) {
        return true;
    }
    if(list.size()%2 != 0) {
        return false;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int v: list) {
        int count = map.getOrDefault(v, 0);
        map.put(v, count+1);
    }
    if(list.get(0) >= 0) {
        Collections.sort(list);    
    }
    else {
        Collections.sort(list, Collections.reverseOrder());
    }        
    
    for(int v: list) {
        int count = map.getOrDefault(v, 0);
        if(count == 0) { //  removed
            continue;
        }
        int dv = v * 2;
        int dcount = map.getOrDefault(dv, 0);
        if(dcount == 0) {
            return false;
        }
        dec(map, v, count);
        dec(map, dv, dcount);
    }
    return map.size() == 0;
}
public List<List<Integer>>  split(int[] a) {
    List<List<Integer>> all = new ArrayList<>();
    List<Integer> pos = new ArrayList<>();
    List<Integer> neg = new ArrayList<>();
    for(int v: a) {
        if(v >= 0) {
            //System.out.println("posv=" + v);
            pos.add(v);
        }
        else {
            neg.add(v);
        }
    }
    all.add(pos);
    all.add(neg);
    return all;
}

public void dec(Map<Integer, Integer> map, int v, int count) {
    if(count == 1) {
        map.remove(v);
    }
    else {
        map.put(v, count-1);
    }
}
}