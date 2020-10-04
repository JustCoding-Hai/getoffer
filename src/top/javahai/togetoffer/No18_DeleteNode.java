package top.javahai.togetoffer;


import top.javahai.leetcode.ListNode;

import java.util.List;

/**
 * @author Hai
 * @date 2020/9/9 - 22:38
 */
public class No18_DeleteNode {
    public static void main(String[] args) {
        ListNode listNode01 = new ListNode(4);
        ListNode listNode02 = new ListNode(5);
        ListNode listNode03 = new ListNode(1);
        ListNode listNode04 = new ListNode(9);
        listNode01.next=listNode02;
        listNode02.next=listNode03;
        listNode03.next=listNode04;
        System.out.println("--------------");
        printListNode(listNode01);

        deleteNode(listNode01,1);
        System.out.println("--------------");
        printListNode(listNode01);

    }
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode current=head;
        if(current.val==val){
            return current.next;
        }
        while(current.next!=null){
            if(current.next.val==val){
                //要删除的结点是最后一个结点
                if(current.next.next==null){
                    current.next=null;
                    break;
                }else{
                    current.next=current.next.next;
                    break;
                }
            }
            current=current.next;
        }
        return head;
    }
    public static void printListNode(ListNode listNode){
        if (listNode==null){
            return;
        }
        ListNode current=listNode;
        System.out.println(current.val);
        while (current.next!=null){
            System.out.println(current.next.val);
            current=current.next;
        }
    }
}
