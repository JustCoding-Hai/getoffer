package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 1486. 数组异或操作
 * @create 2021/1/25 - 22:40
 **/
public class No1486_XorOperation {

    /**
     * 题目：
     * 给你两个整数，n 和 start 。
     * <p>
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     * <p>
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 5, start = 0
     * 输出：8
     * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
     * "^" 为按位异或 XOR 运算符。
     * <p>
     * <p>
     * 输入：n = 4, start = 3
     * 输出：8
     * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }
}
