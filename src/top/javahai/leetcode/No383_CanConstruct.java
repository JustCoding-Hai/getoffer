package top.javahai.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hai
 * @date 2020/8/20 - 23:15
 */
public class No383_CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct2("a","b"));
        System.out.println(canConstruct2("aa","ab"));
        System.out.println(canConstruct2("aa","aab"));

    }
    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     *
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     *
     * 注意：
     *
     * 你可以假设两个字符串均只含有小写字母。
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        /**
         * 使用HashMap存放magazine
         * 遍历ransomNote，HashMap中有需要的字母就+1
         */
        HashMap<Integer, Character> hashMap = new HashMap<>();
        Integer i = 0;
        for (char c : magazine.toCharArray()) {
            hashMap.put(i++,c);
        }
        int count=0;
        for (char c : ransomNote.toCharArray()) {
                //由value找到对应的key,只删除一个
                for (Map.Entry<Integer, Character> entry : hashMap.entrySet()) {
                    if (entry.getValue().equals(c)){
                        hashMap.remove(entry.getKey());
                        count++;
                        break;
                    }
                }
        }
        return count==ransomNote.length()?true:false;
    }

    /**
     * 统计字母个数，两次循环
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] ints = new int[26];
        for (char c : magazine.toCharArray()) {
            ints[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            ints[c-'a']--;
            if (ints[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
