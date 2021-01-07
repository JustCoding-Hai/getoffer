package top.javahai.lcp;

import top.javahai.leetcode.ListNode;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/1/7 - 23:09
 **/
public class No0203_DeleteNode {

    /**
     * 题目：
     * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
     *
     * 示例：
     *
     * 输入：单向链表a->b->c->d->e->f中的节点c
     * 结果：不返回任何数据，但该链表变为a->b->d->e->f
     *
     * 解析
     * 直接node=node.next是不行的，因为前一个节点的next指针仍然指向的是原本的node的地址
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
