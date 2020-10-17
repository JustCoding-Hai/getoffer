package top.javahai.leetcode;


/**
 * @author Hai
 * @program: getoffer
 * @description: 回文链表
 * @create 2020/10/13 - 23:02
 **/
public class No234_IsPalindrome {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next=l1;
        ListNode l2 = new ListNode(2);
        l1.next=l2;
        ListNode l3 = new ListNode(1);
        l2.next=l3;
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));

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

    /**
     * 上面方法的改进，反转一半链表然后与原来的链表进行比较
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
       if (head==null||head.next==null){
            return true;
        }
        int length=0;
        //遍历链表的指针
        ListNode current=head;
        while (current!=null){
            length++;
            current=current.next;
        }
        int half=length/2;
        int count=0;
        //反转前半部分的链表
        ListNode reverse=new ListNode();
        current=head;
        while (count<half&&current.next!=null){
            ListNode next=current.next;
            current.next=reverse.next;
            reverse.next=current;
            current=next;
            count++;
        }
        //如果是奇数，就不要中间的数，后半部分链表不需要第一个
        if (length%2!=0){
            current= current.next;
        }
        //前半部分链表和后半部分比较是否相同
        reverse=reverse.next;
        while (reverse!=null&current!=null){
            if (reverse.val!=current.val){
                return false;
            }
            reverse=reverse.next;
            current=current.next;
        }
        return true;

    }
}
