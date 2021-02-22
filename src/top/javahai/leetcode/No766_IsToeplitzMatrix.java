package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 766. 托普利茨矩阵
 * @create 2021/2/22 - 23:28
 **/
public class No766_IsToeplitzMatrix {


    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }

            }
        }
        return true;
    }
}
