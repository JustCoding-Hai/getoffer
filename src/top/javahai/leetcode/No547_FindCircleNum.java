package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 547. 省份数量
 * @create 2021/1/7 - 23:34
 **/
public class No547_FindCircleNum {

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * <p>
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * <p>
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回矩阵中 省份 的数量。
     * <p>
     * 链接：https://leetcode-cn.com/problems/number-of-provinces
     *
     * @param isConnected
     * @return
     */

    /**
     * 使用深度优先搜索
     * 图：    1-2
     * 3
     * 邻接矩阵表示：
     * 1 1 0
     * 1 1 0
     * 0 0 1
     *
     * @param isConnected 邻接矩阵
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        //城市的数量
        int cities = isConnected.length;
        //记录城市是否被访问过
        boolean[] isVisited = new boolean[cities];
        //记录省份数量
        int province = 0;
        //逐行遍历
        for (int i = 0; i < cities; i++) {
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, cities, i);
                province++;
            }
        }
        return province;
    }

    /**
     * 深度优先搜索策略实现.
     * <p>
     * 预期结果：递归结束，即遍历完一片连通的城市，记录省份+1
     *
     * @param isConnected
     * @param isVisited
     * @param cities
     * @param i
     */
    private void dfs(int[][] isConnected, boolean[] isVisited, int cities, int i) {
        //遍历邻接矩阵的列
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[i] = true;
                dfs(isConnected, isVisited, cities, j);
            }
        }
    }

}
