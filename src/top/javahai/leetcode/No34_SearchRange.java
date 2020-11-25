package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @create 2020/11/25 - 23:07
 **/
public class No34_SearchRange {

    /**
     * 题目：
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            //找到后向两边找相同的数字
            if (nums[mid]==target){
                int l=mid;
                int r=mid;

                if (mid>0){
                     l = mid - 1;
                    while (l>=0&&nums[l] == target) {
                        l--;
                    }
                    //回退到等于target的数对应的数组下标
                    l++;
                }
                if (mid<nums.length-1){
                     r=mid+1;
                    while (r<=nums.length-1&&nums[r]==target){
                        r++;
                    }
                    //回退到等于target的数对应的数组下标
                    r--;
                }


                return new int[]{l,r};
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
