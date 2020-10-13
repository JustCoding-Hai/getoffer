package top.javahai.leetcode;

import java.util.List;

/**
 * @author Hai
 * @program: getoffer
 * @description: 回文链表
 * @create 2020/10/13 - 23:02
 **/
public class No234_IsPalindrome {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(1);
        head.next=l1;
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        ListNode l3 = new ListNode(1);
        l2.next=l3;
        System.out.println(isPalindrome(head));

    }
    /**
     * 问题：
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * 自己想的方法：
     * 反转链表后比较不同
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }

        //原始的链表
        ListNode raw=head;

        //反转后的链表
        ListNode reverse=new ListNode(0);

        //遍历指针
        ListNode current=head;

        ListNode temp;

        //不影响原链表的情况获取反转链表
        while (current!=null){
            temp=new ListNode(current.val);

            temp.next=reverse.next;
            reverse.next=temp;
            current=current.next;

        }
        reverse=reverse.next;
        //逐个看是否相同，有一个不同就不是回文链表
        while (reverse!=null&&raw!=null){
            if (reverse.val!=raw.val){
                return false;
            }
            reverse=reverse.next;
            raw=raw.next;
        }
        return true;
    }
}
