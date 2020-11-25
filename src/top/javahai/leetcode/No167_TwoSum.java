package top.javahai.leetcode;

import com.sun.javafx.iio.ImageStorage;

/**
 * @author Hai
 * @program: getoffer
 * @description: 167. 两数之和 II - 输入有序数组
 * @create 2020/11/23 - 22:25
 **/
public class No167_TwoSum {

    /**
     * 题目：
     *
     给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

     函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

     说明:

     返回的下标值（index1 和 index2）不是从零开始的。
     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     示例:

     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2
     */


    /**
     * 方案1：
     * 1.先根据target数获得符合条件的数组范围
     * 2.然后快慢指针法逐个寻找结果，找不到的情况，快指针的步长就减1.
     *
     * 步长设置是多余的!直接移动快慢指针即可。
     *
     * //TODO failed  思路复杂而且错误
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers==null||numbers.length==0){
            return new int[]{};
        }
        int range=0;
        while (range<=numbers.length-1){
            if (numbers[range]>target){
                break;
            }
            range++;
        }
        //如果target大于数组的所有数,就将范围设为
        if (range>=numbers.length){
            range=numbers.length-1;
        }
        //慢指针
        int slow=0;
        //步长
        int stride=range;
        //快指针,默认为最大
        int fast=stride;

        while (true){
            if (stride==0){
                break;
            }
            while (fast<=range){
                if (numbers[slow]+numbers[fast]==target) {
                    return new int[]{slow+1,fast+1};
                }
                slow++;
                fast+=stride;
            }
            //重新设置快慢指针和步长
            stride--;
            slow=0;
            fast=stride;

        }
        return new int[]{};
    }

    /**
     * 方案2：
     * 1.先找到刚好比target大的数的数组下标range
     * 2.双指针fast和slow，快指针初始为range，慢指针初始为0
     * 3.如果fast+slow指向的数等于target就直接返回
     *                       小于slow++
     *                       大于fast--
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers==null||numbers.length==0){
            return new int[]{};
        }
        int range=0;
        while (range<=numbers.length-1){
            if (numbers[range]>target){
                break;
            }
            range++;
        }
        //如果target大于数组的所有数,就将范围设为
        if (range>=numbers.length){
            range=numbers.length-1;
        }
        int slow=0;
        int fast= range;
        while (slow<fast){
            int temp=numbers[slow]+numbers[fast];
            if (temp==target){
                return new int[]{slow+1,fast+1};
            }else if (temp>target){
                fast--;
            }else{
                slow++;
            }
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target=9;
        int[] sum = twoSum(numbers, target);
        System.out.println(sum);

    }
}
