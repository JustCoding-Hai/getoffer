package top.javahai.leetcode;

import java.util.HashMap;

/**
 * @author Hai
 * @program: getoffer
 * @description: 3. 无重复字符的最长子串
 * @create 2021/3/15 - 17:01
 **/
public class No3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("dvdf"));
        String s = " ";
        char[] charArray = s.toCharArray();
        System.out.println(charArray.length);
        System.out.println((int) charArray[0]);

    }


    /**
     * 建立字符对应的ASCII码数组（共128个）  97-a 拓展ASCII码数组共256个
     * <p>
     * <p>
     * <p>
     * 以这个字符串为例：abcabcbb，当i等于3时，也就是指向了第二个a, 此时我就需要查之前有没有出现过a,
     * 如果出现了是在哪一个位置出现的。然后通过last[index] 查到等于1, 也就是说，如果start 依然等于0的话，
     * 那么当前窗口就有两个a了，也就是字符串重复了，所以我们需要移动当前窗口的start指针，移动到什么地方呢？
     * 移动到什么地方，窗口内就没有重复元素了呢？ 对了，就是a上一次出现的位置的下一个位置，就是1 + 1 = 2。当start == 2,
     * 当前窗口就没有了重复元素，那么以当前字符为结尾的最长无重复子串就是bca,然后再和之前的res取最大值。
     * 然后i指向后面的位置，按照同样思路计算。
     * <p>
     * <p>
     * 滑动窗口法：
     * 代码实现：
     * last数组：用于存放字符上一次出现的位置的后一位下标
     * start用于记录窗口的起始下标
     * res记录窗口的大小
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        //记录字符出现的位置的后一位
        int[] last = new int[128];
        int lenght = s.length();
        //滑动窗口的大小，即结果
        int result = 0;
        //窗口的左侧起始位置
        int start = 0;
        for (int i = 0; i < lenght; i++) {
            int index = s.charAt(i);
            //如果字符出现过了，就将窗口左侧移动到该字符上一次出现过的位置的后一位
            start = Math.max(start, last[index]);
            //更新窗口的大小
            result = Math.max(result, i - start + 1);
            //记录字符的出现的位置
            last[index] = i + 1;
        }
        return result;
    }


    /**
     * 滑动窗口法，使用HashMap辅助实现
     * <p>
     * HashMap存储字符出现的位置的后一位，key为字符，value为坐标
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>(32);
        int result = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            //如果字符c出现过了更新start位置
            start = Math.max(start, indexMap.getOrDefault(c, 0));
            //更新窗口的大小
            result = Math.max(result, end - start + 1);
            //记录字符c出现的位置
            indexMap.put(c, end + 1);
        }
        return result;
    }

}
