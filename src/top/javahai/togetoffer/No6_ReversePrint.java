package top.javahai.togetoffer;

import top.javahai.leetcode.ListNode;

import java.util.Stack;

/**
 * @author Hai
 * @date 2020/9/18 - 18:51
 */
public class No6_ReversePrint {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *遍历链表，放入栈中
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[]{};
        }
        ListNode current=head;
        Stack<ListNode> reverseNode=new Stack<>();
        reverseNode.push(current);
        while(current.next!=null){
            reverseNode.push(current.next);
            current=current.next;
        }
        //返回的数组
        int[] result = new int[reverseNode.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=reverseNode.pop().val;
        }
        return result;
    }
}
