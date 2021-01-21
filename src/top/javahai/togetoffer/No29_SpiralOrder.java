package top.javahai.togetoffer;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * @create 2021/1/21 - 21:42
 **/
public class No29_SpiralOrder {
    /**
     * 题目：
     *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */

    /**
     * 方法1：
     * 制定四个方向的边界，循环遍历
     * l   r
     * 1 2 3 u
     * 4 5 6
     * 7 8 9 b
     * <p>
     * 无论矩阵多大，遍历顺序都是从左到右，从上到下，从右到左，从下到上.每次改变边界
     * 从左到右： l->r,u++
     * 从上到下:  u->b,r--
     * 从右到左： r->l，b--
     * 从下到上： b->u,l++
     * ....重复上述步骤，直至遍历完所有的数组元素
     * <p>
     * 根据矩阵的规律，顺时针遍历到最后一个数组元素的方向只可能是从左到右或从右到左。
     * 所以需要在这里判断是否已经超过了数组元素数量。
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int length = matrix.length;
        int width = matrix[0].length;
        int size = length * width;
        int[] resultArr = new int[size];
        int left = 0;
        int right = width - 1;
        int upper = 0;
        int bottom = length - 1;
        int index = 0;
        while (index < size) {
            //从左到右
            for (int i = left; i <= right; i++) {
                resultArr[index++] = matrix[upper][i];
            }
            //由于进行了边界控制，只有在转换方向的时候需要判断index是否越界
            if (index >= size) {
                break;
            }
            upper++;
            //从上到下
            for (int i = upper; i <= bottom; i++) {
                resultArr[index++] = matrix[i][right];
            }
            right--;
            //从右到左
            for (int i = right; i >= left; i--) {
                resultArr[index++] = matrix[bottom][i];
            }
            if (index >= size) {
                break;
            }
            bottom--;
            //从下到上
            for (int i = bottom; i >= upper; i--) {
                resultArr[index++] = matrix[i][left];
            }
            left++;
        }
        return resultArr;
    }
}
