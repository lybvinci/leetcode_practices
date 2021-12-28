package com.monster.learn;

import java.util.List;

//96.60%
public class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int equalIndex = 0;
        if (ruleKey.equals("type")) {
            equalIndex = 0;
        } else if (ruleKey.equals("color")) {
            equalIndex = 1;
        } else if (ruleKey.equals("name")) {
            equalIndex = 2;
        }
        for (List<String> item : items) {
            if (item.get(equalIndex).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    } 
}
