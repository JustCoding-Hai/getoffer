package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
