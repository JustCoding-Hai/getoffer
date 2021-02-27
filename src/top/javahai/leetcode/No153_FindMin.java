package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 153. 寻找旋转排序数组中的最小值
 * @create 2021/2/27 - 13:02
 **/
public class No153_FindMin {


    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
     *
     * 请找出其中最小的元素。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    /**
     * 二分查找：
     * 数组：4 5 6 7 2 3
     * 数组：6 2 3 3 4 5
     * 目标：找到数组的最小的元素
     * 1. 找到数组的中间元素mid
     * 2. 如果mid大于数组第一个元素，就在mid右边搜索
     * 3. 如果mid小于数组第一个
     *
     * @param nums
     * @return
     */
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
            int middle = (left + right) / 2;
            //判断该点是否是最小的元素
            if (middle - 1 >= left && nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }
            //
            if (middle + 1 <= right && nums[middle + 1] < nums[middle]) {
                return nums[middle + 1];
            }
            if (nums[middle] > nums[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
