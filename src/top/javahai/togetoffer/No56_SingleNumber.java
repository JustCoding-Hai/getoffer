package top.javahai.togetoffer;

import java.util.HashMap;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @create 2021/2/17 - 18:26
 **/
public class No56_SingleNumber {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * <p>
     * <p>
     * 解法：使用map统计
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num) && hashMap.get(num) != -1) {
                hashMap.put(num, -1);
            } else if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            }
        }
        for (Integer num : hashMap.keySet()) {
            if (hashMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 大神解法
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


}
