package top.javahai.togetoffer;

import top.javahai.leetcode.ListNode;

/**
 * @author Hai
 * @date 2020/9/10 - 0:14
 */
public class No22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //先统计链表个数
        int size=0;
        if (head!=null){
            ListNode current=head;
            size++;
            while (current.next!=null){
                size++;
                current=current.next;
            }
            current=head;
            for (int i=0;i<size-k;i++){
                current=current.next;
            }
            return current;
        }
        return null;
    }
}
