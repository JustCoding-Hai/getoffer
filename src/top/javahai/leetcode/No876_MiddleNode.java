package top.javahai.leetcode;

/**
 * 给定一个带有头结点 head (这里头节点就是第一个节点。。。。。)的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author Hai
 * @date 2020/9/20 - 10:19
 */
public class No876_MiddleNode {
    /**
     * 先统计链表长度，再确定指针要指到那个节点
     *
     * 另一种方法：
     * 遍历指针，将每个节点放入数组中
     * 根据下标获取中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode temp=head;
        int size=1;
        while (temp.next!=null){
            size++;
            temp=temp.next;
        }
        int middle=size/2;
        int begin=0;
        temp=head;
        while (temp.next!=null){
            if (middle==begin){
                break;
            }
            temp=temp.next;
            begin++;
        }
        return temp;
    }

    /**
     * 快慢指针
     * slow指针一次向后移动一位
     * fast指针一次向后移动两位
     * @param head
     * @return
     */
    public ListNode middleNode_doublePointer(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //因为fast快于slow指针，所以只用判断fast的指针指向是否为空
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

}
