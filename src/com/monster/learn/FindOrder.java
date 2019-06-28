package com.monster.learn;

import java.util.ArrayList;
import java.util.List;

public class FindOrder {
    //21.85%
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++)
        {
            int course = prerequisites[i][0];
            int pcourse = prerequisites[i][1];
             graph.get(course).add(pcourse);
        }
         int[] visited = new int[numCourses];
         List<Integer> ans = new ArrayList<Integer>();
         for(int i=0;i<numCourses;i++)
             if(DFS(i,graph,visited,ans))
                 return new int[0];
         return ans.stream().mapToInt(i->i).toArray();
     }
      
     public boolean DFS(int curr,ArrayList<ArrayList<Integer>> graph,int[] visited,List<Integer> ans)
     {
         //递归结束条件
         if(visited[curr]==1)//这个节点已经被访问
             return true;
         if(visited[curr]==2)//这个节点没有被访问
             return false;
           
         //业务逻辑处理
         visited[curr]=1;//表示正在访问
         for(int id:graph.get(curr))
             if(DFS(id,graph,visited,ans))
                 return true;
         ans.add(curr);
         visited[curr]=2;//表示已经访问
         return false;
     }
}