package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No94_InorderTraversal {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
          }
      }
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            recursion(root, list);
            return list;
        }

        public void recursion(TreeNode treeNode, List<Integer> list) {
            if(treeNode == null) {
                return;
            }
            recursion(treeNode.left,list);
            list.add(treeNode.val);
            recursion(treeNode.right,list);

        }

}
