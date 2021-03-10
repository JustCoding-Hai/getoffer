package top.javahai.leetcode;

import top.javahai.togetoffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hai
 * @program: getoffer
 * @description: 100. 相同的树
 * @create 2021/3/10 - 22:06
 **/
public class No100_IsSameTree {

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * <p>
     * <p>
     * <p>
     * 如果两个节点都为null则相等
     * 如果有一个节点为null，另一个不为null，则不想等
     * 如果两个都不为null则比较val
     * <p>
     * 递归实现-深度优先遍历
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 广度优先遍历
     * <p>
     * 借助队列实现
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        //两个节点都不为null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null) {
                return false;
            } else if (node1.val != node2.val) {
                return false;
            }
            //存放下一层的各个节点
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }
}
