package com.monster.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//15.83%
public class FindItinerary {

    //[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    public static void main(String[] args) {
        FindItinerary obj = new FindItinerary();
        List<List<String>> tickets = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("JFK");
        tmp.add("SFO");
        tickets.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("JFK");
        tmp.add("ATL");
        tickets.add(tmp);

        tmp = new ArrayList<>();
        tmp.add("SFO");
        tmp.add("ATL");
        tickets.add(tmp);

        tmp = new ArrayList<>();
        tmp.add("ATL");
        tmp.add("JFK");
        tickets.add(tmp);

        tmp = new ArrayList<>();
        tmp.add("ATL");
        tmp.add("SFO");
        tickets.add(tmp);


        obj.findItinerary(tickets);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            List<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
            nbr.add(pair.get(1));
        }
        // 按目的顶点排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
        List<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.remove(0);
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }
}