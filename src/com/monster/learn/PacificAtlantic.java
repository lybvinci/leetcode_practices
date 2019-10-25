package com.monster.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//9.97%
public class PacificAtlantic {
    public boolean[][] vis;
    public boolean[][] vis1;
    public int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new ArrayList<>();
        }
        n=matrix.length;
        m=matrix[0].length;
        boolean[][] path=new boolean[n][m];
        boolean[][] path1=new boolean[n][m];
        vis=new boolean[n][m];
        vis1=new boolean[n][m];
        List<List<Integer>> ret = new ArrayList<>();        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(dfs(i,j,path,matrix,matrix[i][j])&&dfs1(i,j,path1,matrix,matrix[i][j])){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(i);
                    tmp.add(j);
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }

    public boolean dfs(int x,int y,boolean[][] path,int[][] matrix,int pre){
        if(x>=n||y>=m){
            return false;
        }
        if(x<0||y<0){
            return true;
        }
        if(matrix[x][y]>pre){
            return false;
        }
        if(vis[x][y]){
            return path[x][y];
        }
        vis[x][y]=true;
        path[x][y]=dfs(x-1,y,path,matrix,matrix[x][y])||dfs(x,y-1,path,matrix,matrix[x][y])
        ||dfs(x+1,y,path,matrix,matrix[x][y])||dfs(x,y+1,path,matrix,matrix[x][y]);
        vis[x][y]=false;
        return path[x][y];
    }

    public boolean dfs1(int x,int y,boolean[][] path,int[][] matrix,int pre){
        if(x<0||y<0){
            return false;
        }
        if(x>=n||y>=m){
            return true;
        }
        if(matrix[x][y]>pre){
            return false;
        }
        if(vis1[x][y]){
            return path[x][y];
        }
        vis1[x][y]=true;
        path[x][y]=dfs1(x-1,y,path,matrix,matrix[x][y])||dfs1(x,y-1,path,matrix,matrix[x][y])
        ||dfs1(x+1,y,path,matrix,matrix[x][y])||dfs1(x,y+1,path,matrix,matrix[x][y]);
        vis1[x][y]=false;
        return path[x][y];
    }
}