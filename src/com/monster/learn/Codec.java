package com.monster.learn;

//91.21%
public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
     StringBuilder sb = new StringBuilder();
     serializeHelper(sb, root);   
     return sb.toString();
  }

  private void serializeHelper(StringBuilder sb, TreeNode root) {
    if (root == null) {
      sb.append("# ");
    } else {
      sb.append(root.val + ' ');
      serializeHelper(sb, root.left);
      serializeHelper(sb, root.right);
    }
  }

  private int index;
  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    index = 0;
    String[] d = data.split(" ");
    return deserializeHelper(d);
  }

  private TreeNode deserializeHelper(String[] data) {
    if (index > data.length) {
      return null;
    }
    String val = data[index];
    if ("#".equals(val)) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(val));
    index++;
    node.left = deserializeHelper(data);
    index++;
    node.right = deserializeHelper(data);
    return node;
  }
}