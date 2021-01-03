package top.javahai.togetoffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @create 2020/12/8 - 21:40
 **/
public class No57_FindContinuousSequence {
    public static void main(String[] args) {
        int[][] result = findContinuousSequence2(15);
        System.out.println(result.length);
        for (int[] integers : result) {
            for (int i = 0; i < integers.length; i++) {
                System.out.print(integers[i]+" ");
            }
            System.out.println();
        }
    }


    /**
     * 题目：
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     *
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * 示例 1：
     *
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     *
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {

        return null;
    }

    /**
     * 暴力法   ——超出时间限制。。。。。。。。。。。。
     *1.从1到target-1遍历所有的数
     * 2.每个数，从该数起始开始累加，如果等于target就放入到结果中，如果大于跳出本次循环
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence2(int target) {
        ArrayList<int[]> tempResult = new ArrayList<>();

        for (int i = 1; i < target; i++) {
            int sum=0;
            int index=0;
            int[] arr = new int[target-i];
            for (int j = i; j < target; j++) {
                sum+=j;
                if (sum>target){
                    sum=0;
                    index=0;
                    break;
                }
                arr[index++]=j;
                //如果找到了符合要求的连续正整数
                if (sum == target) {
                    int[] act_arr = new int[index];
                    for (int k = 0; k <=index-1; k++) {
                        act_arr[k]=arr[k];
                    }
                    tempResult.add(act_arr);
                    sum = 0;
                    break;
                }
            }

        }
        //将list转化为二维数组
        int[][] result = new int[tempResult.size()][];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i]= tempResult.get(i);
        }

        return result;

    }
}
