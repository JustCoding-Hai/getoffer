package top.javahai.leetcode;

import java.util.Arrays;

/**
 * @author Hai
 * @program: getoffer
 * @description: 189. 旋转数组
 * @create 2021/3/6 - 23:08
 **/
public class No189_Rotate {

    public static void main(String[] args) {
        int n = 7;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(arr, 3);
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     *  
     *
     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 逐个移位法，要进行整个数组的元素移动k-1次
     * <p>
     * 耗时太长了233ms
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int end = nums.length - 1;
        //i为旋转步数（次数）
        for (int i = 0; i < k; i++) {
            //保存最后一个元素的值
            int endNum = nums[end];
            int index = 0;
            int temp = nums[index];
            while (index < end) {
                int nextNum = nums[++index];
                nums[index] = temp;
                temp = nextNum;
            }
            //将最后一个元素放在数组第一位
            nums[0] = endNum;
        }
    }

    /**
     * 数组翻转法，只需要进行元素移动3次
     * 1.先将数组整个翻转
     * 2.将0~k个元素翻转
     * 3.将k+1个元素翻转
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * <p>
     * <p>
     * 7 6 5 4 3 2 1
     * <p>
     * 5 6 7 4 3 2 1
     * <p>
     * 5 6 7 1 2 3 4
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        //因为k可能超出数组长度，需要进行取模
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end++;
        }
    }


    /**
     * 使用额外数组
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * nums[i+k%length]=num[i]
     *
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
        System.out.println(Arrays.toString(nums));
    }

}
