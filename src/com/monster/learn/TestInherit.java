package com.monster.learn;

public class TestInherit {
  public static class Parent {
    public Parent() {}
    public void run() {
      System.out.println("parent");
    }
  }

  public static class Son extends Parent {
    public Son() {
      super();
    }

    @Override
    public void run() {
      System.out.println("son");
    }
  }

  public static void main(String[] args) {
    Son son = new Son();
    Parent p = (Parent) son;
    p.run();
  }
  
}
