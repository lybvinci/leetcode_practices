package com.monster.learn;

import java.util.HashMap;
import java.util.Map;

//54.5%
public class TopVotedCandidate {
  int[] leading;
    int[] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        time = times;
        leading = new int[persons.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : persons){
            map.put(n, 0);
        }
        int max = persons[0];
        for (int i = 0; i < times.length; i++){
            if (i == 0){
                map.put(persons[i], 1);
                leading[i] = persons[i];
            }else{
                map.put(persons[i], map.get(persons[i]) + 1);
                if (max != persons[i] && map.get(persons[i]) >= map.get(max)){
                    max = persons[i];
                }
                leading[i] = max;
            }
        }
         
    }
     
    public int q(int t) {
        int i = 0, j = time.length;
        while (i < j){
            int mid = i + (j - i) / 2;
            if (time[mid] <= t){
                i = mid + 1;
            }else{
                j = mid;
            }
        }
        return leading[i - 1];
    }

  public static void main(String[] args) {
    TopVotedCandidate tvc = new TopVotedCandidate(new int[]{0,0,1,1,2}, new int[]{0,67,69,74,87});
    tvc.q(100);
  }
}