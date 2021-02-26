package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/2/26 - 16:16
 **/
public class No27_RemoveElement {


    /**
     * 题目：
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
     * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param val
     * @return
     */

    /**
     * 双指针法，index指针用于指向不等于val的位置，而i指针用于遍历数组
     * 只有当i指针指向的位置的数不等于val，nums[index] = nums[i]，index指针右移一位。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /**
     * 双指针法，等于 val 的元素很少的时候，较少复制的次数。
     * index指针用于指向交换位置的下标，默认为数组长度
     * i指针用于遍历数组，发现nums[i] == val才与index 处交换，同时index--
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int index = nums.length;
        while (i < index) {
            if (nums[i] == val) {
                nums[i] = nums[index - 1];
                index--;
            } else {
                i++;
            }
        }
        return index;
    }
}
