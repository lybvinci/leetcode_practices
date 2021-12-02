package com.monster.learn;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

//46.07%
public class EatenApples {

    public int eatenApples(int[] apples, int[] days) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer l1, Integer l2) { 
                return l1 - l2;
            }
        });
        int res = 0;
        for (int i = 0; i < apples.length || !queue.isEmpty(); i++) {
            while(!queue.isEmpty() && queue.peek() == i) {
                map.remove(i);
                queue.poll();
            }
            if (i < apples.length && apples[i] > 0) {
                map.put(i + days[i], apples[i]);
                queue.offer(i+days[i]);
            }
            if (!queue.isEmpty()) {
                res++;
                int c = queue.peek();
                int rest = map.getOrDefault(c, 0);
                if (rest > 0) {
                    rest--;
                }
                if (rest <=0) {
                    queue.poll();
                    map.remove(c);
                } else {
                    map.put(c, rest);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EatenApples ea = new EatenApples();
        ea.eatenApples(new int[]{0,47,47,0,27,11,24,2,0,0,32,12,34,24,40,28,35,16,0,38,0,0,30,17,11,0,0,47,0,33,27,7,43,0,0,43,41,10,35,27,43,8,0,0,10,5,3,0,1,24,17,0,17,0,0,22,41,35,0,10,16,8,10,17,0,38,35,18,6,29,9,0,14,11,0,0,43,14,17,3,6,4,2,44,6,18,26,0,23,11,37,37,1,47}, new int[]{0,19,68,0,37,17,35,3,0,0,17,23,2,23,25,24,51,27,0,41,0,0,51,29,21,0,0,60,0,33,50,4,7,0,0,16,77,4,44,17,65,7,0,0,3,4,3,0,1,24,1,0,22,0,0,41,62,39,0,20,3,3,10,16,0,71,53,32,8,31,14,0,15,5,0,0,15,9,7,4,3,5,3,82,5,16,25,0,3,5,57,34,2,73});
    }
}
