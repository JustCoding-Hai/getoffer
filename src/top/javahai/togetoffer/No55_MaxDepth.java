package top.javahai.togetoffer;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 55 - I. 二叉树的深度
 * @create 2020/11/16 - 0:02
 **/
public class No55_MaxDepth {
    /**
     * 题目：
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 例如：
     *
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */


    /**
     * 递归实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int nLeft = maxDepth(root.left);
        int nRight = maxDepth(root.right);
        return Math.max(nLeft,nRight)+1;

    }

    /**
     * 统计二叉树的层数——非递归实现——层序遍历（BFS）
     * 实现步骤：
     * 1.创建一个Queue用于保存每一层的所有结点
     * 2.先将头节点加入到队列中
     * 3.只要队列不为空（终止条件：队列为空），就遍历队列中所有的结点，获取结点的左右结点（如果有的话）添加到队列中。
     * 4.遍历过程中需要获取并删除当前结点
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //计算层数
        int count=0;
        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //poll方法作用：获取并移除此队列的头，或者返回null ，如果此队列为空。
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }

            }

        }
        return count;

    }

}
