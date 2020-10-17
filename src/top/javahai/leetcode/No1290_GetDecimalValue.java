package top.javahai.leetcode;


/**
 * @author Hai
 * @program: getoffer
 * @description: 1290.二进制链表转整数
 * @create 2020/10/17 - 20:27
 **/
public class No1290_GetDecimalValue {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,3));
        ListNode ln1 = new ListNode(0);
        ListNode ln2 = new ListNode(1);
        System.out.println(getDecimalValue2(ln1));
        System.out.println(getDecimalValue2(ln2));
        ln2.next=ln1;
        ListNode ln3 = new ListNode(1);
        ln1.next=ln3;
        System.out.println(getDecimalValue2(ln2));

    }

    /**
     * 题目描述：
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     *
     * 请你返回该链表所表示数字的 十进制值 。
     *
     *  输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        if (head==null){
            return 0;
        }
        //先统计链表结点个数
        ListNode current=head;
        int length=0;
        while (current!=null){
            length++;
            current=current.next;
        }
        //进行计算
        int result=0;
        current=head;
        //根据二进制转十进制公式进行计算 如101=2^2+2^1*0+2^0=5
        for (int i = length-1; i >= 0; i--) {
            if (current!=null){
                if (current.val==1){
                    result+=Math.pow(2,i);
                }
                current=current.next;
            }
        }

        return result;

    }

    /**
     * 使用位运算，链表从头部移到尾部的过程，可以看成二进制向左移动的过程
     * @param head
     * @return
     */
    public static int getDecimalValue2(ListNode head) {
        if (head==null){
            return 0;
        }
        ListNode current=head;
        int result=0;
        while (current!=null){
            //二进制向左移动一位，然后进行赋值
            result<<=1;
            result+=current.val;
            current=current.next;
        }
        return result;
    }
}
