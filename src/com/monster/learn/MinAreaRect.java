package com.monster.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//14.92%
public class MinAreaRect {
  public int minAreaRect(int[][] points) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
        int minArea = Integer.MAX_VALUE;
 
        // save each point into map by key as x, value as multiple y
        for(int[] point : points)
        {
            if(!map.containsKey(point[0]))
                map.put(point[0], new HashSet<>());
 
            map.get(point[0]).add(point[1]);
        }
 
        // find 2 diagonal points and then find the other 2 diagonal points to calculate the area
        for(int[] point1 : points)
        {
            for(int[] point2: points)
            {
                if(point1[0] == point2[0] || point1[1] == point2[1]) // if point1 and point2 are not diagonal
                    continue;
 
                if(map.get(point1[0]).contains(point2[1]) && map.get(point2[0]).contains(point1[1])) // if find the other 2 diagonal points
                    minArea = Math.min(minArea, Math.abs(point2[0] - point1[0]) * Math.abs(point2[1] - point1[1]));
            }
        }
 
        return minArea == Integer.MAX_VALUE ? 0 : minArea;

  } 
}