package top.javahai.leetcode;

import java.util.List;
import java.util.Objects;

/**
 * @author Hai
 * @date 2020/8/30 - 10:53
 */
public class No2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode ln3 = new ListNode(6);
        ListNode ln4 = new ListNode(6);
        ListNode ln5 = new ListNode(6);
        l1.next=ln1;
        ln1.next=ln2;
        l2.next=ln3;
        ln3.next=ln4;
        ln4.next=ln5;
        ListNode listNode = new No2_AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode current=listNode;
        while (current!=null){
            System.out.print(current.val+"->");
            current=current.next;
        }
    }
    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(Objects.isNull(l1)||Objects.isNull(l2)){
            return null;
        }
        ListNode result = new ListNode(0);
        return recursiveAddListNode(l1,l2,result,false);
    }

    /**
     * 这里只考虑到了L1和L2两条链表长度不同的情况，未考虑L1和L2相加大于10的情况，需要多一个节点
     * @param l1
     * @param l2
     * @param result
     * @param tenMore
     * @return
     */
    public ListNode recursiveAddListNode(ListNode l1, ListNode l2,ListNode result,boolean tenMore){
        int add=0;
        if (tenMore) {
            add=1;
        }
        //如果链表的节点为空，就补0
        int l1Val=l1==null?0:l1.val;
        int l2Val=l2==null?0:l2.val;
        if (l1Val+l2Val+add>=10){
            tenMore=true;
            result.val=(l1Val+l2Val+add)%10;
        }else{
            tenMore=false;
            result.val=l1Val+l2Val+add;
        }
        //遍历到两条链表的最后一个节点的情况
        if ((l1==null||l1.next==null)&&(l2==null||l2.next==null)){
            result.next=new ListNode(0);
            if (tenMore){
                result.next.val=1;
            }else {
                result.next=null;
            }
            return result;
        }
        result.next=new ListNode(0);
        recursiveAddListNode(l1==null?null:l1.next,l2==null?null:l2.next,result.next,tenMore);
        return result;
    }


    /**
     *
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    private ListNode recursive(ListNode l1, ListNode l2, int carry) {
        // 递归结束条件
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int l1Val = l1 == null ? 0 : l1.val;
        int l2Val = l2 == null ? 0 : l2.val;
        int curSum = l1Val + l2Val + carry;
        ListNode curNode = new ListNode(curSum % 10);
        curNode.next = recursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, curSum / 10);
        return curNode;
    }
}


