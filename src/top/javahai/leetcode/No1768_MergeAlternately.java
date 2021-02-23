package top.javahai.leetcode;

/**
 * @author Hai
 * @program: getoffer
 * @description: 1768. 交替合并字符串
 * @create 2021/2/23 - 18:40
 **/
public class No1768_MergeAlternately {
    public static void main(String[] args) {


    }

    /**
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     * <p>
     * 返回 合并后的字符串 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "abc", word2 = "pqr"
     * 输出："apbqcr"
     * 解释：字符串合并情况如下所示：
     * word1：  a   b   c
     * word2：    p   q   r
     * 合并后：  a p b q c r
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-strings-alternately
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int tempLength = length1 > length2 ? length2 : length1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tempLength; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if (length1 > length2) {
            result.append(word1.substring(tempLength));
        } else if (length1 < length2) {
            result.append(word2.substring(tempLength));
        }
        return result.toString();
    }

    public String mergeAlternately2(String word1, String word2) {
        int length01 = word1.length();
        int length02 = word2.length();
        char[] result = new char[length01 + length02];
        int tempLength = length01 > length02 ? length01 : length02;
        int index = 0;
        for (int i = 0; i < tempLength; i++) {
            if (i < length01) {
                result[index++] = word1.charAt(i);
            }
            if (i < length02) {
                result[index++] = word2.charAt(i);
            }
        }
        return new String(result);
    }

}
