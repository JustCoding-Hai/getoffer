package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hai
 * @program: getoffer
 * @description: Leetcode 54. 螺旋矩阵
 * @create 2021/1/21 - 23:10
 **/
public class No54_SpiralOrder {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int length = matrix.length;
        int width = matrix[0].length;
        int size = length * width;
        int left = 0;
        int right = width - 1;
        int upper = 0;
        int bottom = length - 1;
        int index = 0;
        while (index < size) {
            //从左到右
            for (int i = left; i <= right && index < size; i++) {
                list.add(matrix[upper][i]);
                index++;
            }
            upper++;
            //从上到下
            for (int i = upper; i <= bottom && index < size; i++) {
                list.add(matrix[i][right]);
                index++;
            }
            right--;
            //从右到左
            for (int i = right; i >= left && index < size; i--) {
                list.add(matrix[bottom][i]);
                index++;
            }
            bottom--;
            //从下到上
            for (int i = bottom; i >= upper && index < size; i--) {
                list.add(matrix[i][left]);
                index++;
            }
            left++;
        }
        return list;

    }
}
