package top.javahai.leetcode;

import java.util.HashSet;

/**
 * @author Hai
 * @date 2020/8/19 - 22:48
 */
public class No389_FindTheDifference {
    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。注意添加的字母可能是存在相同的
     *
     * 示例:
     *
     * 输入：s = "abcd" t = "abcde"
     *
     * 输出：e
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int[] sInts = new int[26];
        int[] tInts = new int[26];
        for (char c:s.toCharArray()){
            sInts[c-'a']++;
        }
        for (char c:t.toCharArray()){
            tInts[c-'a']++;
        }
        for (int i=0;i<=26;i++){
            if (sInts[i]<tInts[i]){
                return (char) (i+'a');
            }
        }
        return '0';
    }
    public static char findTheDifference2(String s, String t) {
        int[] sInts = new int[26];
        for (char c:s.toCharArray()){
            sInts[c-'a']++;
        }
        for (char c:t.toCharArray()){
            sInts[c-'a']--;
            if ( sInts[c-'a']==-1){
                return c;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("ancva","ancvao"));
    }
}
