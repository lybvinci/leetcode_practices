package com.monster.learn;

import java.util.HashMap;
import java.util.Map;

//25.86%
public class MinAreaFreeRect {

  private Map<String,Boolean> map;
   
    public double minAreaFreeRect(int[][] points) {
       
        int n=points.length;
        map=new HashMap<>();
        double ans=Double.MAX_VALUE;
       
        for(int i=0;i<n;i++)
            map.put(String.valueOf(points[i][0])+"#"+String.valueOf(points[i][1]), true);
       
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++) {
                    if(i==j) break;
                    if(i==k || j==k) continue;
                    if(check(points[i],points[j],points[k]))
                        ans=Math.min(ans, findArea(points[i],points[j],points[k]));
                }
       
        return ans==Double.MAX_VALUE?0:ans;
    }
   
    private double findArea(int[] a,int[] b,int[] c) {
       
        double x=Math.sqrt((b[0]-a[0])*(b[0]-a[0])+(b[1]-a[1])*(b[1]-a[1]));
        double y=Math.sqrt((c[0]-a[0])*(c[0]-a[0])+(c[1]-a[1])*(c[1]-a[1]));
       
        return x*y;
    }
   
    private boolean check(int[] a,int[] b,int[] c) {
       
        int dx1=b[0]-a[0];
        int dy1=b[1]-a[1];
        int dx2=c[0]-a[0];
        int dy2=c[1]-a[1];
       
        if(dx1*dx2+dy1*dy2!=0)
            return false;
       
        int dx3=b[0]+dx2;
        int dy3=b[1]+dy2;
        String s=String.valueOf(dx3)+"#"+String.valueOf(dy3);
       
        if(!map.containsKey(s))
            return false;
       
        return true;
    }

    //97.41%
    public double minAreaFreeRect2(int[][] points) {
      double ans = Double.MAX_VALUE;
      for (int i = 0; i < points.length; i++) {
        for (int j = i + 1; j < points.length; j++) {
          double x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
          double distance = Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
          double centerX = (x1 + x2) / 2, centerY = (y1 + y2) / 2;
          for (int k = j + 1; k < points.length; k++) {
            double x3 = points[k][0], y3 = points[k][1];
            double d = Math.sqrt(Math.pow(x3 - centerX, 2) + Math.pow(y3 - centerY, 2));
            if (Math.abs(d * 2 - distance) <= 0.000001) {
              double x4 = 2 * centerX - x3, y4 = 2 * centerY - y3;
              for (int l = 0; l < points.length; l++) {
                if (Math.abs(points[l][0] - x4) <= 0.000001 && Math.abs(points[l][1] - y4) <= 0.000001) {
                  double area=Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3))* Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
                  ans = Math.min(ans, area);
                }
              }
            }
          }
        }
      }
      return ans == Double.MAX_VALUE ? 0 : ans;
    } 
}
