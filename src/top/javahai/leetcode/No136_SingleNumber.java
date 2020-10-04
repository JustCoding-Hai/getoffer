package top.javahai.leetcode;

import java.util.*;

/**
 * 问题：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * @author Hai
 * @date 2020/8/31 - 22:25
 */
public class No136_SingleNumber {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,1,2,4};
        System.out.println(No136_SingleNumber.singleNumber(arr));
    }
    /**
     * 使用HashSet来去重
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
//            if (hashSet.contains(num)){
//                hashSet.remove(num);
//                continue;
//            }
//            hashSet.add(num);
            //优化写法
            if (!hashSet.add(num)){
                hashSet.remove(num);
            }
        }
        return hashSet.iterator().next();
    }

    /**
     * 使用异或运算
     * 异或运算规则：
     * 1.a^0=a
     * 2.a^a=0
     * 3.异或运算满足交换律和结合律 ：a^b^a=a^a^b=0^b=b
     * @param nums
     * @return
     */
    public static int singleNumber02(int[] nums) {
       int result=0;
        for (int num : nums) {
            result^=num;
        }
        return result;
    }
}
