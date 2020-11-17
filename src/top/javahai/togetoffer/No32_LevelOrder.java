package top.javahai.togetoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
     * 借助Queue来完成
     *
     * 层序遍历（广度优先搜索BFS）：
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
                    linkedList.offer(node.left);
                }
                if (node.right!=null){
                    linkedList.offer(node.right);
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



    /**
     *
     * 递归实现：
     * 1.使用List<List<Integer>>，其中List<Integer>用于存储每一层的结点的数值。
     * 2.递归的时候，记录层数，每下一层height+1，根据height来保存数值到List<Integer>中
     * 3.这样，先递归左子树，再递归右子树
     * @param root
     * @return
     */
    public int[] levelOrder2(TreeNode root) {
        //每一层的从左到右的结点数值
        List<List<Integer>> list = new ArrayList<>();
        levelHelper(list, root, 0);
        //将每个结点的数值按顺序放入到数值集合中
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.addAll(list.get(i));
        }

        //把list转化为数组
        int[] res = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }

    public void levelHelper(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null){
            return;
        }
        if (height >= list.size()) {
            list.add(new ArrayList<>());
        }
        levelHelper(list, root.left, height + 1);
        list.get(height).add(root.val);
        levelHelper(list, root.right, height + 1);
    }

}
