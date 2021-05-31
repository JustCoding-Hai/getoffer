package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 342. 4的幂
 * @create 2021/5/31 - 23:26
 **/
public class No342_IsPowerOfFour {
    /**
     * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }

    /**
     * 0xaaaaaaaa为十六进制的数，其二进制表示，它所有偶数二进制位都是0，所有奇数二进制位都是1，因为4的幂的二进制仅有的
     * 1一定在偶数位上。
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        return n > 0 && ((n & (n - 1)) == 0) && (n & 0xaaaaaaaa) == 0;
    }

    /**
     * 如果n是4的幂，那么它除以3的余数一定为1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour3(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
