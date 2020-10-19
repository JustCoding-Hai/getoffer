package top.javahai.togetoffer;

import top.javahai.leetcode.ListNode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * @create 2020/10/19 - 23:02
 **/
public class No25_MergeTwoLists {
    /**
     * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 示例2：
     * 输入：1->15->30, 1->3->4
     * 输出：1->1->3->4->15-30
     *
     * 迭代解法：
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并后的链表
        ListNode mergeList = new ListNode();
        //遍历合并链表的索引
        ListNode mergeTemp=mergeList;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                mergeTemp.next=l1;
                l1=l1.next;
            }else {
                mergeTemp.next=l2;
                l2=l2.next;
            }
            mergeTemp=mergeTemp.next;
        }
        //最后可能l1有剩或l2有剩
        mergeTemp.next=l1==null?l2:l1;
        return mergeList.next;

    }

    /**
     * 递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


}
