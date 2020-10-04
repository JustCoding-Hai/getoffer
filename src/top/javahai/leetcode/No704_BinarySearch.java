package top.javahai.leetcode;

/**
 * @author Hai
 * @date 2020/8/3 - 22:36
 */
public class No704_BinarySearch {
  public static void main(String[] args) {
   int[] nums={-1,0};
   int target=-1;
    System.out.println(search(nums,target));
    System.out.println(recursiveSearch(nums,0,nums.length-1,target));
  }

  /**
   * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
   *
   * 示例 1:
   * 输入: nums = [-1,0,3,5,9,12], target = 9
   * 输出: 4
   * 解释: 9 出现在 nums 中并且下标为 4
   * 示例 2:
   *
   * 输入: nums = [-1,0,3,5,9,12], target = 2
   * 输出: -1
   * 解释: 2 不存在 nums 中因此返回 -1
   * @param nums
   * @param target
   * @return
   */
  public static int search(int[] nums, int target) {
    int start=0;
    int end=nums.length-1;
    int mid=end/2;
    while(nums[mid]!=target){
      if (nums[mid]>target){
        end=mid-1;
        mid=(end+start)/2;
      }
      if (nums[mid]<target){
        start=mid+1;
        mid=(end+start)/2;
      }
      if (start>end){
        return -1;
      }
    }
    return mid;
  }
  //递归实现
  public static int recursiveSearch(int[] nums,int begin,int end,int target){
    if (begin>end)
      return -1;
    int mid=(end+begin)/2;
    if (nums[mid]>target){
      return recursiveSearch(nums,begin,mid-1,target);
    }
    if (nums[mid]<target){
      return recursiveSearch(nums,mid+1,end,target);
    }
    else
      return mid;

  }
}
