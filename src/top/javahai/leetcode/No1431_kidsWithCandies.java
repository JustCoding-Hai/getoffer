package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hai
 * @program: getoffer
 * @description: 1431. 拥有最多糖果的孩子
 * @create 2021/1/25 - 22:54
 **/
public class No1431_kidsWithCandies {

    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * <p>
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：candies = [2,3,5,1,3], extraCandies = 3
     * 输出：[true,true,true,false,true]
     * 解释：
     * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
     * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
     * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
     * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * 示例 2：
     * <p>
     * 输入：candies = [4,2,1,1,2], extraCandies = 1
     * 输出：[true,false,false,false,false]
     * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
     * <p>
     * 提示：
     * <p>
     * 2 <= candies.length <= 100
     * 1 <= candies[i] <= 100
     * 1 <= extraCandies <= 50
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //数据量小，先找到最大的数
        int maxNum = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (maxNum < candies[i]) {
                maxNum = candies[i];
            }
        }
        ArrayList<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxNum) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

    /**
     * 代码优化
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        //数据量小，先找到最大的数
        int maxNum = candies[0];
        for (int i = 1; i < candies.length; i++) {
            maxNum = Math.max(maxNum, candies[i]);
        }
        ArrayList<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= maxNum);
        }
        return list;
    }
}
