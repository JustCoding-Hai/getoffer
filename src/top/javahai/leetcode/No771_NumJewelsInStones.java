package top.javahai.leetcode;

import java.util.HashSet;

/**
 * @author Hai
 * @program: getoffer
 * @description: 771. 宝石与石头
 * @create 2021/1/20 - 23:15
 **/
public class No771_NumJewelsInStones {
    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     * 示例 1:
     *
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     *
     * 示例 2:
     *
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     *
     */


    /**
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        char[] jawelArr = jewels.toCharArray();
        char[] stoneArr = stones.toCharArray();

        int count = 0;
        for (int i = 0; i < stoneArr.length; i++) {
            char stone = stoneArr[i];
            for (int j = 0; j < jawelArr.length; j++) {
                if (jawelArr[j] == stone) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 用set集合
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int count = 0;
        HashSet<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
