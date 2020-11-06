package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Hai
 * @program: getoffer
 * @description: 26. 删除排序数组中的重复项
 * @create 2020/11/6 - 23:01
 **/
public class No26_RemoveDuplicates {
    /**
     * 题目：
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *  
     *
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    /**
     * 题目要求按顺序来修改数组，所以使用HashSet行不通
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < integers.size();i++) {
            nums[i]=iterator.next();

        }

        return integers.size();
    }

    /**
     * 双指针法
     * 定义i指针（慢指针）初始为0和j指针（快指针）初始为1
     *
     * 当arr[i]==arr[j]的时候，j继续向前操作
     * 而当不等于的时候，i向前一位，将j当前的值赋值给i所在的位置
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int i=0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]){
                i++;
                if (j-i>=1){
                    nums[i]=nums[j];
                }
            }

        }
        return i+1;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        System.out.println(map.size());
        HashSet hashSet=new HashSet();
        hashSet.add(1);
        hashSet.add(1);
        System.out.println(hashSet.size());
        hashSet.iterator().next();
    }
}
