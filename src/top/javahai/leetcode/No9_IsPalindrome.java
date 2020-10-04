package top.javahai.leetcode;


/**
 * 题目：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * @author Hai
 * @date 2020/8/30 - 19:40
 */
public class No9_IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12143));
    }
    /**
     * 双向指针
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int left=0;
        int right=chars.length-1;
        if (chars[0]=='-'||chars[right]=='0'&&chars.length!=1){
            return false;
        }
        while(left<right){
            if (chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 不将数字转化为字符串
     * @param x
     * @return
     */
    public static boolean isPalindrome02(int x) {

        return false;
    }

    /**
     * 使用StringBuilder的reverse函数
     * @param x
     * @return
     */
    public static boolean isPalindrome03(int x) {
        String s = new StringBuilder(x + "").reverse().toString();
        return s.equals(String.valueOf(x));
    }

}
