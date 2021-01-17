package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 1480. 一维数组的动态和
 * @create 2021/1/17 - 23:59
 **/
public class No1480_RunningSum {

    /**
     * 题目：
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * <p>
     * 请返回 nums 的动态和。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            resultArr[i] = sum;
        }
        return resultArr;
    }

    /**
     * 精简代码
     *
     * @param nums
     * @return
     */
    public int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
