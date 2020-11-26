package top.javahai.togetoffer;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 64. 求1+2+…+n
 * @create 2020/11/26 - 21:35
 **/
public class No64_SumNums {


    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * 示例 1：
     *
     * 输入: n = 3
     * 输出: 6
     * 示例 2：
     *
     * 输入: n = 9
     * 输出: 45
     *  
     * 限制：
     *
     * 1 <= n <= 10000
     */

    /**
     * 等差队列公式
     * @param n
     * @return
     */
    public int sumNums(int n) {
        return (1+n)*n/2;
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int sumNums2(int n) {
        return n==0?0:n+sumNums2(n-1);
    }


    /**
     * 使用&&逻辑运算符，
     * 以逻辑运算符 && 为例，对于 A && B 这个表达式，如果 A 表达式返回 \textit{False}False ，
     * 那么 A && B 已经确定为 \textit{False}False ，此时不会去执行表达式 B。同理，对于逻辑运算符 ||， 对于 A || B 这个表达式，
     * 如果 A 表达式返回 \textit{True}True ，那么 A || B 已经确定为 \textit{True}True ，此时不会去执行表达式 B。
     *
     * @param n
     * @return
     */
    public int sumNums3(int n) {
        boolean flag=n>0&&(n+=sumNums3(n-1))>0;
        return n;
    }


}
