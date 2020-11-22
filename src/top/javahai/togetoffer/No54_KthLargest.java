package top.javahai.togetoffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @create 2020/11/18 - 23:14
 **/
public class No54_KthLargest {

    /**
     *
     *
     */


    /**
     * 二叉搜索树的特性是：中序遍历获得的结点序列，就是有序的。
     *
     * 1.中序遍历一次，获取所有的结点
     * 2.根据输入的k输出第k大的结点
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        inOrderTraversal(root,treeNodes);

        //treeNodes.forEach(treeNode -> System.out.println(treeNode));

        //treeNodes= (ArrayList<TreeNode>) treeNodes.stream().sorted((t1, t2)-> t1.val >= t2.val?0:1).collect(Collectors.toList());



        return treeNodes.get(treeNodes.size()-k).val;
    }

    /**
     * 遍历二叉树，添加结点到List中
     * @param root
     * @param treeNodes
     * @return
     */
    private void inOrderTraversal(TreeNode root, ArrayList<TreeNode> treeNodes) {

        if (root==null){
            return;
        }
        inOrderTraversal(root.left,treeNodes);
        treeNodes.add(root);
        inOrderTraversal(root.right,treeNodes);
    }
}
