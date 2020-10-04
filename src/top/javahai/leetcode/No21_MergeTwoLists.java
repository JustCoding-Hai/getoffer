package top.javahai.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 创建一个新的链表，用于存放返回的合并后的链表
 * 同时遍历链表，比较大小
 *  * @author Hai
 * @date 2020/9/12 - 0:04
 */
public class No21_MergeTwoLists {
    ListNode mergeListNode = new ListNode();

    /**
     * 思路1：
     * 1.定义一个插入链表的方法，每次插入都需要遍历，效率太低
     * 2.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeListNode = new ListNode();
        //遍历指针
        ListNode mergeTemp = mergeListNode;
        /**
         *遍历两个链表，注意不能两个同时插入，可能有这种情况：
         * 输入：1->5->8, 18->3->4
         */
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mergeTemp.next = l1;
                l1 = l1.next;
            } else {
                mergeTemp.next = l2;
                l2 = l2.next;
            }
            mergeTemp = mergeTemp.next;

        }
        //连接后续多出来的
        mergeTemp.next = l1 == null ? l2 : l1;
        return mergeListNode.next;
    }
}
