package top.javahai.leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * @author Hai
 * @date 2020/8/5 - 22:17
 */
public class No703_KthLargest {

  /**
   * Your KthLargest object will be instantiated and called as such:
   * KthLargest obj = new KthLargest(k, nums);
   * int param_1 = obj.add(val);
   */
  //int[] kNums;
  ArrayList<Integer> kNums=new ArrayList<Integer>();
  int k;
  /**
   * 问题：如何缩短缩短数组的排序？
   * 1.排序一次计算原数组的最大的前k个数
   * 2.后续加入的数与前k个数进行比较，小就忽视，大就重新排序数组
   *
   * 使用ArrayList存放前k大的元素
   * 构造器：
   * 1.先对数组进行排序
   * 2.如果接收的数组nums的长度小于k，就直接将nums的元素都加入到Arraylist中
   * 3.如果大于，就只取后k个元素（前k大的元素）加入到ArrayList中
   * 添加方法：
   * 1.直接添加到ArrayList中，只有当ArrayList的大小大于1才进行后续操作
   * 2.对ArrayList中的元素进行排序
   * 3.如果ArrayList的大小大于k，就移除第一项
   * 4.最后ArrayList的大小等于k返回第一项的值，否则就是不存在第k大的值返回null
   * @param k
   * @param nums
   */
  public No703_KthLargest(int k, int[] nums) {
    this.k=k;
    if (null!=nums&&nums.length>0) {
      Arrays.sort(nums);
      if (nums.length<=k){
        for (int i=0;i<nums.length;i++){
          kNums.add(nums[i]);
        }
      }else {
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
          kNums.add(nums[i]);
        }
      }
    }
   // kNums.forEach(System.out::println);
  }

  /**
   * 添加val到数组nums后，返回数组中第k大的数
   * @param val
   * @return
   */
  public Integer add(int val) {
   // kNums.forEach(System.out::println);
    kNums.add(val);
    if (kNums.size()>1){
      kNums.sort((x1,x2)->Integer.compare(x1,x2));
      if (kNums.size()>k){
        kNums.remove(0);
      }
    }
    return kNums.size()==k?kNums.get(0):null;
  }
  public static void main(String[] args) {
//    int k = 3;
//    int[] arr = {4,5,8,2};
//    No703_KthLargest kthLargest = new No703_KthLargest(3, arr);
//    System.out.println(kthLargest.add(3));//4
//    System.out.println(kthLargest.add(5));//5
//    System.out.println(kthLargest.add(10));//5
//    System.out.println( kthLargest.add(9));//8
//    System.out.println(kthLargest.add(4));//8
//    System.out.println("++++++++++++");
    int k1=1;
    int[] arr1=new int[10];
    No703_KthLargest kthLargest1 = new No703_KthLargest(2, new int[]{0});
    System.out.println(kthLargest1.add(-3));
    System.out.println(kthLargest1.add(-2));
    System.out.println(kthLargest1.add(-4));
    System.out.println(kthLargest1.add(0));
    System.out.println(kthLargest1.add(4));

  }
}

