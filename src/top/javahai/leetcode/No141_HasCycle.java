package top.javahai.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Hai
 * @program: getoffer
 * @description: 141. 环形链表
 * @create 2020/10/12 - 23:32
 **/
public class No141_HasCycle {
    /**
     * 题目:
     *
     给定一个链表，判断链表中是否有环。

     如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

     如果链表中存在环，则返回 true 。 否则，返回 false 。
     进阶：

     你能用 O(1)（即，常量）内存解决此问题吗？

     *
     * 暴力解法:
     * 借助HashMap来判断是否有重复
     *
     * @param head
     * @return
     */

    public static boolean hasCycle(ListNode head) {
        //只有一个节点
        if (head==null||head.next==null){
            return false;
        }
        ListNode current=new ListNode();
        current.next=head;
        //记录下标
        int index=0;
        //存储遍历过的ListNode
        HashMap<Integer, ListNode> nodeHashMap = new HashMap<>();

        while (current.next!=null){
            if (nodeHashMap.containsValue(current.next)){
                return true;
            }
            nodeHashMap.put(index,current.next);
            index++;
            //遍历下一个节点
            current=current.next;
        }
        return false;
    }

    /**
     * 用HashSet解决
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        HashSet<ListNode> nodeHashSet = new HashSet<>();
        while (head.next!=null){
            if (!nodeHashSet.add(head.next)){
                return true;
            }
            head=head.next;
        }
        return false;
    }


    /**
     * 「Floyd 判圈算法」（又称龟兔赛跑算法）
     * 使用快慢指针,fast指针每次走两步，slow指针每次走一步，如果链表存在环， fast必然追上slow指针（同时指向同一个节点）,如果不存在环，
     * fast就会一直到slow的前面
     * @param head
     * @return
     */
    public static boolean hasCycle3(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            if (fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }

    //TODO其他写法：https://leetcode-cn.com/problems/linked-list-cycle/solution/3chong-jie-jue-fang-shi-liang-chong-ji-bai-liao-10/





    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next=node1;
        node1.next=head;
        node2.next=node3;
        node3.next=node1;
        System.out.println(hasCycle(head));
        HashMap<Integer, ListNode> nodeHashMap = new HashMap<>();
        nodeHashMap.put(1,node1);
        System.out.println(nodeHashMap.containsValue(node1));
    }
}


