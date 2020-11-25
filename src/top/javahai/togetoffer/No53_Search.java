package top.javahai.togetoffer;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @create 2020/11/25 - 21:51
 **/
public class No53_Search {


    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     *
     *
     * 二分查找找到后双指针找到所有相同的数，记录次数
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            //找到后统计两边相同的数字
            if (nums[mid]==target){
                int sum=1;
                if (mid>0) {
                    int l = mid - 1;
                    while (l>=0&&nums[l] == target) {
                        sum++;
                        l--;
                    }
                }
                if (mid<nums.length-1){
                    int r=mid+1;
                    while (r<=nums.length-1&&nums[r]==target){
                        sum++;
                        r++;
                    }
                }
                return sum;

            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return 0;
    }
}
