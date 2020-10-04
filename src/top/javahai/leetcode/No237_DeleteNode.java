package top.javahai.leetcode;

import sun.util.resources.cldr.et.CurrencyNames_et;

import java.util.List;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 * 示例 1：
 *
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @author Hai
 * @date 2020/9/18 - 19:05
 */
public class No237_DeleteNode {

    /**
     * 单向链表删除结点常见的方法是：要删除的结点的上一个结点的next指向要删除的结点的next
     * 但是如果不能访问前面的指针，那就当前要删除的结点变成它的下一个结点
     * @param node
     */
    public void deleteNode(ListNode node) {
      node.val=node.next.val;
      node.next=node.next.next;
    }
}
