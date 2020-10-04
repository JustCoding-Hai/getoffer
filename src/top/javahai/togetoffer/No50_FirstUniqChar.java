package top.javahai.togetoffer;

import java.sql.SQLOutput;
import java.util.HashSet;

/**
 * @author Hai
 * @date 2020/8/27 - 23:44
 */
public class No50_FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    /**
     * 问题：
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * s = "abaccdeff"
     * 返回 "b"
     *
     * s = ""
     * 返回 " "
     */
    /**
     * 思路1：
     * 使用Set
     * 1.将字符串转化为char数组
     * 2.添加到Set，如果添加失败就设置字符删除
     * Set是无序数组，所以又要List，又要Set性能应该不好
     *
     * 使用字符数组记录方式
     *
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        if (s.equals(" ")){
            return ' ';
        }
        char[] chars = s.toCharArray();
        int[] arr=new int[26];
        for (char c : chars) {
            arr[c-'a']++;
        }
        for (char c : chars) {
            if (arr[c-'a']==1){
                return c;
            }
        }
        return ' ';
    }
}
