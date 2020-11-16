package top.javahai.togetoffer;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @create 2020/11/17 - 0:03
 **/
public class No32_LevelOrder {
    /**
     * 题目：
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     *  
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     * 实现：
     * 使用Queue来完成
     *
     *1.从左到右遍历将每一层结点添加到队列中，获取结点的同时删除
     * 2.当队列为空的时候，则说明遍历完了二叉树
     *
     *
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[]{};
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        LinkedList<Integer> nums = new LinkedList<>();
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            while (size>0){
                TreeNode node = linkedList.poll();
                nums.add(node.val);
                if (node.left!=null){
                    linkedList.add(node.left);
                }
                if (node.right!=null){
                    linkedList.add(node.right);
                }
                size--;
            }

        }
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            result[i]=nums.get(i);
        }
        return result;
    }
}
