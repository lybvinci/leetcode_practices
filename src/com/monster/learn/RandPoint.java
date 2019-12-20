package com.monster.learn;

//94.12%
public class RandPoint {
  private double radius;
	private double x_center,y_center;
  public void solution(double radius, double x_center, double y_center) {
    this.radius=radius;
    this.x_center=x_center;
    this.y_center=y_center;
  }
  
  public double[] randPoint() {
    double x=this.x_center-radius;
    double y=this.y_center-radius;
    
    while(true) {
      double xx=x+Math.random()*radius*2;
      double yy=y+Math.random()*radius*2;
      if(Math.sqrt(Math.pow(xx-this.x_center,2)+Math.pow(yy-this.y_center, 2))<=this.radius){
        return new double[]{xx,yy};
      }
    }
  }
}