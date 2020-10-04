package top.javahai.togetoffer;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.HashMap;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]

 * @author Hai
 * @date 2020/8/1 - 11:40
 */
public class No57_twoSum {
  /**
   * 1.先二分缩小范围，比较中位数
   * 2.再左右指针遍历计算
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums,int target){
    //限制输入数据
    //首先给定数据是升序的，首先找到中位数
    int begin=0;
    int end=nums.length-1;
    int mid=(end-begin)/2;
    int left=0;
    int right=nums.length-1;
    while (nums[mid]>target){
      end=mid-1;
      mid=(end-begin)/2;
      right=mid;
    }
    //得到的范围的数都小于等于target，左右指针遍历求值
    int sum=nums[left]+nums[right];
    while (sum!=target){
      if (left>=right){
        break;
      }
      if (sum>target){
        right--;
      }else{
        left++;
      }
      sum=nums[left]+nums[right];
    }
    int[] result={nums[left],nums[right]};
    return result;
  }

  /**
   * 另外一种写法，利用HashMap的containsKey或containsValue方法
   * 1.循环遍历数组，将遍历到的数放入HashMap中
   * 2.判断当前遍历到的数nums[i]-target的值是否已保存在HashMap中
   * 3.已存在就返回
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums,int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int needNum=target-nums[i];
      if (map.containsValue(needNum)){
        return new int[]{nums[i],needNum};
      }
      map.put(i,nums[i]);
    }
    return new int[]{};
  }
  public static void main(String[] args) {
    int[] nums={10,18,25,33,36,50,50,52,55,74};
    int target=126;
   int[] result=twoSum2(nums,target);
    for (int s : result) {
      System.out.println(s);
    }
 }
}
