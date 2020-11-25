package top.javahai.togetoffer;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 58 - II. 左旋转字符串
 * @create 2020/11/25 - 21:26
 **/
public class No58_ReverseLeftWords {

    /**
     * 题目：
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     *示例 1：
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     *
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
//        String temp=s.substring(n);
//        char[] chars = s.toCharArray();
//        StringBuilder result = new StringBuilder(temp);
//        for (int i = 0; i < n; i++) {
//            result.append(chars[i]);
//        }
//        return result.toString();
        return s.substring(n)+s.substring(0,n);

    }
}
