package top.javahai.togetoffer;

import java.util.HashSet;

/**
 * 题目：找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * @author Hai
 * @date 2020/8/26 - 23:23
 */
public class No3_FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums={5,3,3,4,2,1};
        System.out.println(new No3_FindRepeatNumber().findRepeatNumber03(nums));
    }

    public int findRepeatNumber(int[] nums) {
        HashSet<String> hashSet = new HashSet<>();
        for (int num : nums) {
            int size=hashSet.size();
            String s=String.valueOf(num);
            hashSet.add(s);
            if (hashSet.size()==size){
                return num;
            }
        }
        return -1;
    }
    /**
     * 使用HashSet的改进版
     * 1.add方法就返回了boolean，标记是否添加成功
     * 2.HashSet可以对基本数据类型的包装类型进行去重
     */

    public int findRepeatNumber02(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)){
                return num;
            }
        }
        return -1;
    }
    /**
     * 一个萝卜一个坑的写法：
     * 利用题目说明的一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
     * 说明没有重复数据的话，数组的下标就对应的值就是下标值
     *
     * 遍历数组，为数找到存放位置,值与相等的下标值对应的数比较，不想等就交换，相等就返回该数
     */
    public int findRepeatNumber03(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //如果原本就在对应的位置，就跳过
            if (i==nums[i]){
                continue;
            }
            if (nums[i]==nums[nums[i]]){
                return nums[i];
            }
            //否则交换两个数的位置
            int temp=nums[nums[i]];
            nums[nums[i]]=nums[i];
            nums[i]=temp;
        }
        return -1;
    }
}
