package top.javahai.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author Hai
 * @date 2020/9/20 - 11:58
 */
public class No203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //手动构造出一个带有哨兵节点的链表
        /**
         * 哨兵节点去解决它，哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等，
         * 它们是纯功能的，通常不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
         */
        ListNode temp=new ListNode();
        temp.next=head;
        ListNode current=temp;

        while (current.next!=null){
            if (current.next.val==val){
                //要删除的节点是最后一个的情况(其实不用判断，最后一个节点的话current.next.next==null)
                if (current.next.next==null){
                    current.next=null;
                }else {
                    current.next=current.next.next;
                }
            }
            current=current.next;
        }
        return head;
    }
}
