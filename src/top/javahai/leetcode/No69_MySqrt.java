package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 69. x 的平方根
 * @create 2021/4/12 - 17:12
 **/
public class No69_MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }

    /**
     * x的平方根的整数部分ans是满足k的平方小于等于 的最大k值，因此k进行二分查找得到答案
     * <p>
     * 二分查找的下界为0，上界为x的平方，在二分查找的过程通过上面的不等式不断缩小范围，最终能得到最大k值。
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
