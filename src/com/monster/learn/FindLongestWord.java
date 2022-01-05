package com.monster.learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindLongestWord {

    //88.87%
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        int maxLength = 0;
        List<String> maybe = new ArrayList<>();
        for (String tmp : dictionary) {
            int index = 0;
            boolean find = true;
            for (int i = 0; i < tmp.length(); i++) {
                if (index >= s.length()) {
                    find = false;
                    break;
                }
                index = s.indexOf(tmp.charAt(i), index);
                if (index == -1) {
                    find = false;
                    break;
                } else {
                    index++;
                }
            }
            if (!find) {
                continue;
            }
            if (maxLength == tmp.length()) {
                maybe.add(tmp);
            } else if (maxLength < tmp.length()) {
                maxLength = tmp.length();
                maybe.clear();
                maybe.add(tmp);
            }
        }
        if (maybe.size() < 1) {
            return ans;
        }
        maybe.sort(Comparator.naturalOrder());

        return maybe.get(0);
    } 

    //"abpcplea"
// ["ale","apple","monkey","plea"]
    public static void main(String[] args) {
        FindLongestWord flw = new FindLongestWord();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("aaa");
        dictionary.add("aa");
        dictionary.add("a");
        flw.findLongestWord("aaa", dictionary);
    }

}
