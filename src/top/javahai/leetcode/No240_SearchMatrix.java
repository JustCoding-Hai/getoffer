package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: No240. 搜索二维矩阵 II
 * @create 2021/4/16 - 22:10
 **/
public class No240_SearchMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{-1, 3}};
        System.out.println(searchMatrix(arr, -1));

    }

    /**
     * 题目：
     * <p>
     * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     * 题解：
     * <p>
     * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
     * 1.每一行数组的二分查找(更快)
     * 2. 标记数: 根据该二维矩阵的数据结构特点，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 所以以右上角的节点作为标记数flagNum，如果flagNum<target，就纵坐标i++
     * 如果flagNum>target，就横坐标j++
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1, flagNum = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }

}
