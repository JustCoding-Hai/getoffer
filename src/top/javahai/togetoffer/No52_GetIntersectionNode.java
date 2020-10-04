package top.javahai.togetoffer;

import top.javahai.leetcode.ListNode;

/**
 *编写一个程序，找到两个单链表相交的起始节点。
 * @author Hai
 * @date 2020/9/19 - 23:07
 */
public class No52_GetIntersectionNode {
    /**
     * 双指针遍历
     *
     * 链表A的非公共部分长度设为l1，链表B的非公共部分设为L2，公共部分设为C
     * 那么当两条指针都走过L1+L2+C的长度的那个位置就是第一个公共节点。
     * 实现：指针A遍历完链表A，就指向链表B的第一个节点。指针B遍历完链表B，就指向链表A的第一个节点继续遍历，
     *       直到两个指针指向的节点是同一个节点。
     *       如果两个链表没有公共节点的情况，就是两个指针指向的下一个节点都为null的情况
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //判空
        if (headA==null||headB==null){
            return null;
        }
        //两个遍历指针
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=tempB){
            //判断是否有公共节点
            if (tempA.next==null&&tempB.next==null){
                return null;
            }
            tempA=tempA.next==null?headB:tempA.next;
            tempB=tempB.next==null?headA:tempB.next;
        }
        return tempA;
    }
}
