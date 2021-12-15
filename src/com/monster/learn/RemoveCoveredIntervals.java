package com.monster.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RemoveCoveredIntervals {

    //94.92%
    public int removeCoveredIntervals(int[][] intervals) {
        int ans = 0;
        if (intervals.length < 2) {
            return intervals.length;
        }
        int[][] list = new int[intervals.length][2];
        list[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            boolean droped = false;
            for (int j = 0; j < list.length; j++) {
                if (list[j] == null) {
                    continue;
                }
                if (intervals[i][0] >=list[j][0] && intervals[i][1] <= list[j][1]) {
                    droped = true;
                    break;
                } else if (list[j][0] >= intervals[i][0] && list[j][1] <= intervals[i][1]) {
                    list[j] = null;
                }
            }
            if (!droped) {
                list[i] = intervals[i];
            } else {
                list[i] = null;
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                ans++;
            }
        }
        return ans;
    } 

    public static void main(String[] args) {
        RemoveCoveredIntervals rci = new RemoveCoveredIntervals();
        rci.removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}});
    }
}
