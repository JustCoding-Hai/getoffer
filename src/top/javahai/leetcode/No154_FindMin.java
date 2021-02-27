package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 154. 寻找旋转排序数组中的最小值 II
 * @create 2021/2/27 - 17:36
 **/
public class No154_FindMin {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        //如果数组没有旋转
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right--;
            }
        }
        return nums[left];
    }

}
