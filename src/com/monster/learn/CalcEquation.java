package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//100%
public class CalcEquation {
    public static void main(String[] args) {
        CalcEquation ce = new CalcEquation();
        String[][] a1 = new String[][]{{"a","b"}, {"b", "c"}};
        List<List<String>> a = new LinkedList<>();
        for (int i = 0; i < a1.length; i++) {
            a.add(Arrays.asList(a1[i]));
        }
        double[] b1 = new double[]{2.0, 3.0};

        List<List<String>> c = new LinkedList<>();
        String[][] c1 = new String[][]{{"a","c"},{"b","a"}, {"a","e"}, {"a", "a"}, {"x", "x"}};
        for (int i = 0; i < c1.length; i++) {
            c.add(Arrays.asList(c1[i]));
        }
        ce.calcEquation(a, b1, c);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuedPairs = new HashMap<>();
        for(int i = 0 ; i < equations.size() ; i++) {
            List<String> equation = equations.get(i);
            //被除数
            String multiplied = equation.get(0);
            //除数
            String multiplier = equation.get(1);//除数
            if(!pairs.containsKey(multiplied)) {
                pairs.put(multiplied, new ArrayList<>());
                valuedPairs.put(multiplied, new ArrayList<>());
            }
            
            if(!pairs.containsKey(multiplier)) {
                pairs.put(multiplier, new ArrayList<>());
                valuedPairs.put(multiplier, new ArrayList<>());
            }
            pairs.get(multiplied).add(multiplier);
            pairs.get(multiplier).add(multiplied);
            valuedPairs.get(multiplied).add(values[i]);
            valuedPairs.get(multiplier).add(1.0 / values[i]);
        }
        
        //结果集
        double[] result = new double[queries.size()];
        for(int i = 0 ; i<queries.size() ; i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), pairs, valuedPairs, new HashSet<>(), 1.0);
            result[i] = result[i]==0.0 ? -1.0 : result[i];
        }
        return result;
    }
    
    public double dfs(String multiplied, String multiplier, Map<String, List<String>> pairs, Map<String, List<Double>> valuedPairs, Set<String> visited, double curResult) {
        if(!pairs.containsKey(multiplied))
            return 0.0;
        if(visited.contains(multiplied))
            return 0.0;
        if(multiplied.equals(multiplier))
            return curResult;
        visited.add(multiplied);
        List<String> multipliers = pairs.get(multiplied);
        List<Double> multiplierValues = valuedPairs.get(multiplied);
        double tmp = 0.0;
        for(int i = 0 ; i<multipliers.size() ; i++) {
            tmp = dfs(multipliers.get(i), multiplier, pairs, valuedPairs, visited, curResult * multiplierValues.get(i));
            if(tmp != 0.0){
                break;
            }
        }
        visited.remove(multiplied);
        return tmp;
    }
}