package top.javahai.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Hai
 * @program: getoffer
 * @description: 1512. 好数对的数目
 * @create 2020/12/22 - 22:42
 **/
public class No1512_NumIdenticalPairs {

    /**
     * 给你一个整数数组 nums 。
     *
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     *
     * 返回好数对的数目。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,1,1,3]
     * 输出：4
     * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     *
     * 示例 3：
     *
     * 输入：nums = [1,2,3]
     * 输出：0
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 使用组合公式：x*(x-1)/2
     * 遍历一次数组将数放入到Map中，再遍历一次Set根据x*(x-1)/2的公式计算所有的组合。
     * 如数组中有三个1，则有3*(3-1)/2=3种组合（好数对）
     * @param nums
     * @return
     */
    public int numIdenticalPairs2(int[] nums) {
        int[] arr = new int[101];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                result+=arr[i]*(arr[i]-1)/2;
            }
        }
        return result;
    }

    /**
     * 使用map
     */
    public int numIdenticalPairs3(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer v = entry.getValue();
            ans += v * (v - 1) / 2;
        }
        return ans;
    }
}
