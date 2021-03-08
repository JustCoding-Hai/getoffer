package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 1365. 有多少小于当前数字的数字
 * @create 2021/1/21 - 23:22
 **/
public class No1365_SmallerNumbersThanCurrent {
    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     *
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     *
     * 以数组形式返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     * 解释：
     * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     * 对于 nums[1]=1 不存在比它小的数字。
     * 对于 nums[2]=2 存在一个比它小的数字：（1）。
     * 对于 nums[3]=2 存在一个比它小的数字：（1）。
     * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 方法一：暴力法
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    /**
     * 方法2：快速排序，
     * 1.记录每个元素的原始数组的下标
     * 2.排序
     * 3.排序后的数组向左找到第一个比自身小的数  的下标+1，即为结果。（比它小的所有数字的数目）
     * <p>
     * 如：
     * nums = [8,1,2,2,3]
     * <p>
     * 0  8
     * 1  1
     * 2  2
     * 3  2
     * 4  3
     * 排序后：
     * nums = [1,2,2,3,8]
     * <p>
     * 结果：  [4,0,1,1,3]
     *
     * 效率不行
     * @param nums
     * @return
     */
//    public int[] smallerNumbersThanCurrent2(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        //记录每个元素的原始数组的下标
//        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(i, nums[i]);
//        }
//        //对数组进行排序
//        quickSort(nums, 0, nums.length - 1);
//        //记录结果
//        int[] arr = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.)
//            arr[hashMap.get(nums[i])] = i;
//        }
//        return arr;
//    }

    /**
     * 快速排序算法实现
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //x表示基准数
            int i = left, j = right, x = arr[left];
            while (i < j) {
                //从左到右找第一个小于X的值
                while (i < j && arr[j] >= x) {
                    j--;
                }
                //将找到的数放到前面
                if (i < j) {
                    arr[i++] = arr[j];
                }
                //在左边找到比X大的值，填上右边的坑
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            //i=j，此时来到数组中间位置，将基准数X放到该位置，左边元素都小于X，右边元素都大于X
            arr[i] = x;
            //对数组左边递归执行
            quickSort(arr, left, i - 1);
            //对数组右边递归执行
            quickSort(arr, i + 1, right);
        }

    }


    /**
     * 计数排序
     * <p>
     * 因为题目规定0 <= nums[i] <= 100，所以可以建立频次数组来统计数字的次数，数组arr下标0~100
     * 而小于arr[i]的个数为(arr[0]..arr[i-1])的和。
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        //频次数组
        int[] arr = new int[101];
        //统计数字个数
        for (int num : nums) {
            arr[num]++;
        }
        //统计比当前数字小的个数
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        //在原来的数组上操作统计
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? 0 : arr[nums[i] - 1];
        }
        return nums;
    }
}
