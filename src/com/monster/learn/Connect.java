package com.monster.learn;

//66.48%
public class Connect {
  public Node2 connect(Node2 root) {
    if (root == null) {
      return root;
    }      
    connectToNode(root.left, root.right);
    return root;
  }  

  private void connectToNode(Node2 left, Node2 right) {
    if (left == null || right == null) {
      return;
    }
    left.next = right;
    connectToNode(left.left, left.right);
    connectToNode(right.left, right.right);
    connectToNode(left.right, right.left);
  }
}
