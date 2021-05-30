package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 231. 2 的幂
 * @create 2021/5/30 - 22:48
 **/
public class No231_IsPowerOfTwo {


    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/power-of-two
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 递归求法
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    /**
     * 位运算：
     * 2的幂次方的数的二进制表示只有一位是1，
     * 通过n&(n-1)的运算可以把n的二进制的最低位的1去掉变为0，如果n&(n-1)=0则该数就是2的幂次方
     * 比如：
     * 8&7=01000&00111=00000 11&10=01011&01010=01010
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(36));
    }
}
