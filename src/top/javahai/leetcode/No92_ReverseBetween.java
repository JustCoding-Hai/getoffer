package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 92. 反转链表 II
 * @create 2021/3/20 - 23:01
 **/
public class No92_ReverseBetween {
    public static void main(String[] args) {

    }


    /**
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * <p>
     * 新建一个链表用于存储反转链表
     * <p>
     * <p>
     * 定义3个指针：
     * current：永远指向待反转区域的第一个节点，current会移动的，直到超出反转区域
     * next：current的下一个节点
     * pre：永远指向初始的待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //反转链表
        ListNode reverseList = new ListNode(0);
        //遍历反转链表的指针
        ListNode pre = reverseList;
        //遍历原链表的指针
        ListNode current = head;
        //记录指针的下一个节点
        ListNode next;
        int count = 0;
        while (current != null) {
            count++;
            //这部分的链表要反转
            if (count >= left && count <= right) {
                next = current.next;
                current.next = reverseList.next;
                reverseList.next = current;
                current = next;
            }
            //不需要反转的部分
            else {
//                reverseCurrent.next = current;
//                reverseCurrent = reverseList.next;
                reverseList.next = current;
                pre = reverseList.next;
                current = current.next;
            }
        }
        return reverseList.next;
    }
}
