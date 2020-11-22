package top.javahai.togetoffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 09. 用两个栈实现队列
 * @create 2020/11/22 - 22:55
 **/
public class CQueue {

    /**
     * 题目意思：使用两个栈实现队列的先进先出.
     * stack1用于插入，stack2用于删除。
     *
     * 使用LinkedList，其底层使用链表存储，相比于Stack的使用数据存储，减少了扩容和删除的时间消耗。
     *
     * 实现步骤：
     * 执行删除的时候，
     * 如果stack2为空，就将stack1的所有值pop出来，push到stack2中。
     * 如果stack2不为空，就直接pop出stack2的值
     * 如果stack2和stack1都为空就返回-1
     */

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;


    public CQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    /**
     * 直接添加到stack1中
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);

    }

    /**
     * 删除的时候，将stack1的所有的数放入到stack2中，执行pop操作。
     * @return
     */
    public int deleteHead() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }

    }
}
