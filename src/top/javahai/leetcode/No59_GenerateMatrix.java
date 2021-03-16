package top.javahai.leetcode;

import java.util.Arrays;

/**
 * @author Hai
 * @program: getoffer
 * @description: 59. 螺旋矩阵 II
 * @create 2021/3/16 - 23:05
 **/
public class No59_GenerateMatrix {
    /**
     * 题目：
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * <p>
     * n=3
     * 1 2 3
     * 8 9 4
     * 7 6 5
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(1);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }

    /**
     * 分为4个方向进行循环赋值，循环终止条件为大于n*n
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        int bound = n * n;
        while (count <= bound) {
            //从左到右
            for (int i = left; i <= right && count <= bound; i++) {
                result[top][i] = count++;
            }
            top++;
            //从上到下
            for (int i = top; i <= bottom && count <= bound; i++) {
                result[i][right] = count++;
            }
            right--;
            //从右到左
            for (int i = right; i >= left && count <= bound; i--) {
                result[bottom][i] = count++;
            }
            bottom--;
            //从下到上
            for (int i = bottom; i >= top && count <= bound; i--) {
                result[i][left] = count++;
            }
            left++;
        }
        return result;
    }

}
