package top.javahai.leetcode;

import java.util.List;

/**
 * @author Hai
 * @date 2020/8/30 - 10:53
 */
public class No2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode ln3 = new ListNode(6);
        ListNode ln4 = new ListNode(4);
        l1.next=ln1;
        ln1.next=ln2;
        l2.next=ln3;
        ln3.next=ln4;
        ListNode listNode = new No2_AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        return recursiveAddListNode(l1,l2,result);
    }
    public ListNode recursiveAddListNode(ListNode l1, ListNode l2,ListNode result){
        result.val=l1.val+l2.val;
        while (l1.next!=null&&l2.next!=null){
            result.next=new ListNode(0);
            recursiveAddListNode(l1.next,l2.next,result.next);
        }
        return result;
    }
}


