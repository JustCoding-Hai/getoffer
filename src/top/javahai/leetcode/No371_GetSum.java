package top.javahai.leetcode;

/**
 * @author Hai
 * @date 2020/8/21 - 23:44
 */
public class No371_GetSum {
    public static void main(String[] args) {
        System.out.println(new No371_GetSum().getSum(-4,3));
    }

    /**
     * 使用位运算符进行二进制加法运算
     * 1.计算低位 相当于两个数进行异或操作^
     * 2.计算进位 相当于两个数进行与操作&再左移一位(左移一位用于进位后续更高位计算)
     * 3.重复上面的1，2步。当进位为零，就结束计算，a就是结果
     * @param a 上一次相加结果的低位
     * @param b 上一次相加结果的进位
     * @return
     */
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
