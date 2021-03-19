package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 打家劫舍
 * @create 2021/3/19 - 10:37
 **/
public class No198_Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }


    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * <p>
     * todo 下面代码错了，因为每次遍历步长都是固定的，实际可能每次的步长不一样
     * 导致求出来的值是错误的。
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int result = 0;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        for (int step = 2; step <= nums.length; step++) {
            for (int i = 0; i < nums.length; i++) {
                int index = i;
                int count = 0;
                while (index < nums.length) {
                    count += nums[index];
                    index += step;
                }
                result = count > result ? count : result;
                System.out.println(result);
            }
        }
        return result;
    }

    /**
     * 动态规划求解
     * nums=[1,2,3,4]
     * <p>
     * 假设有4个房屋
     * 前1个房屋的最大金额S0=v0=1
     * 前2个房屋的最大金额S1=Max(S0,v1);
     * 前3个房屋的最大金额S2=Max(S1,S0+v2)；（只偷前两个和偷第三个的情况）
     * 前4个房屋的最大金额S3=Max(S2,S1+V3);
     * <p>
     * 可推导出公式
     * Sn=Max(S（n-1），s（n-2）+vn)
     * <p>
     * <p>
     * 用数组记录前n个房屋可以偷的最大价值
     *
     * @param nums
     * @return
     */
    static int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        //记录前n个房屋可以偷的最大价值
        int[] value = new int[length];
        //先记录前两个房屋的最大价值
        value[0] = nums[0];
        value[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        //按上述公式进行求
        for (int i = 2; i < length; i++) {
            value[i] = Math.max(value[i - 1], value[i - 2] + nums[i]);
        }
        return value[length - 1];
    }

    /**
     * 动态规划+滚动数组。
     * <p>
     * 只记录前面（n-2）件房的最大值和(n-1)房的最大值。即不是用数组存储
     *
     * @param nums
     * @return
     */
    static int rob3(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = nums[0] > nums[1] ? nums[0] : nums[1];
        //按上述公式进行求
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}
