package top.javahai.leetcode;

import java.util.*;

/**
 * @author Hai
 * @program: getoffer
 * @description: 350. 两个数组的交集 II
 * @create 2020/11/3 - 22:59
 **/
public class No350_Intersect {
    /**
     * 问题：
     *      * 给定两个数组，编写一个函数来计算它们的交集。
     *      *
     *      * 示例 1：
     *      *
     *      * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     *      * 输出：[2,2]
     *      * 示例 2:
     *      *
     *      * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     *      * 输出：[4,9]
     */
    public static void main(String[] args) {
        int[] num1={1,2,2,1};
        int[] num2={2,2};
        int[] intersect = intersect(num1, num2);
        for (int i : intersect) {
            System.out.println(i);
        }

    }

    /**
     *
     *解法1：将num1的所有元素放入到HashMap中记录出现的次数，key为数，value为该数出现的次数。
     * nums2中的数在集合中存在，就对次数进行减一。并且放入到记录结果的集合中。
     *
     * 这样做实现了题目中提到的以下要求，不需要比较两个数组每个数的出现次数
     * 题目要求：输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        //优化算法，将数组长度较小的放在map中
        if (nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }

        //统计第一个数组的所有数的个数，并放入到map
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i : nums1) {
            if (map.get(i)!=null){
                Integer value = map.get(i)+1;
                map.put(i, value);
            }else{
                map.put(i, 1);
            }
        }

        //遍历num2的数，去map中取值，匹配上就放入到结果List中。
        List<Integer> result = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i)&&map.get(i)!=0){
                result.add(i);
                int newCount = map.get(i) - 1;
                map.put(i,newCount);
            }
        }

        //将list的结果放入到数组中
        int[] resultArr=new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i]=result.get(i);
        }

        return resultArr;

    }


    /**
     *解法2-双指针法：
     * 首先对两个数组进行排序，定义两个指针指向两个数组，如果两个指针指向的数字相等就同时移向下一个数；
     * 如果指向的数字不同就小的指针向右移动。任意一个指针越界就完成了交集的查找。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        //排序两个数组
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //结果数组
        int[] result = new int[Math.min(nums1.length,nums2.length)];
        //结果数组的指针
        int index=0;
        int index1=0;
        int index2=0;
        while (index1<nums1.length&&index2<nums2.length){
            if (nums1[index1]==nums2[index2]){
                result[index]=nums1[index1];
                index++;
                index1++;
                index2++;
            }else{
                if (nums1[index1]<nums2[index2]){
                    index1++;
                }else {
                    index2++;
                }
            }
        }
        //Arrays.copyOfRange方法的作用是复制指定数组的指定范围的数据生成新的数组
        return Arrays.copyOfRange(result,0,index);

    }

}
