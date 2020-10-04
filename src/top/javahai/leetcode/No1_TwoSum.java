package top.javahai.leetcode;

import java.util.HashMap;

/**
 * 问题：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author Hai
 * @date 2020/8/29 - 23:56
 */
public class No1_TwoSum {
    public static void main(String[] args) {
        int[] ints = new No1_TwoSum().twoSum02(new int[]{3, 2, 4}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 暴力法：
     * 两次for循环遍历找到两个值相加等于target的下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 借用HashMap实现一次遍历，接住了HashMap的containsKey函数进行查找
     * 遍历数组将元素添加到HashMap，通过target计算当前值需要相加的值为多少，判断现在HashMap中是否已存在
     * 存在就立即返回结果
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int requiredNum=target-nums[i];
            if (hashMap.containsKey(requiredNum)){
                return new int[]{hashMap.get(requiredNum),i};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
}
