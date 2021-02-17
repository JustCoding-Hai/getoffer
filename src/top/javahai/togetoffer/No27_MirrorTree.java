package top.javahai.togetoffer;

import java.util.Stack;

/**
 * @author Hai
 * @program: getoffer
 * @description: 二叉树的镜像
 * @create 2021/2/17 - 17:57
 **/
public class No27_MirrorTree {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        System.out.println(stack.pop());
    }

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     * <p>
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     * <p>
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            swap(root);
            //交换左子树的左右结点
            mirrorTree(root.left);
            //交换右子树的左右结点
            mirrorTree(root.right);
        }
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /**
     * 借助栈实现,由上到下，由左到右进行遍历交换
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return null;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            //交换左右结点
            swap(node);
        }
        return root;
    }

}
