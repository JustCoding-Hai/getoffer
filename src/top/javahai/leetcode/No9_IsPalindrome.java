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
        System.out.println(isPalindrome02(121));
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
        if ((chars[0]=='-'||chars[right]=='0')&&chars.length!=1){
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
     *
     * 例如：1221
     * 前置条件：负数或个位数为0的数一定不是回文数
     *                                                   反转得到的数字
     * 1221%10=1  获得最后的一个数=1，1221/10=122          1
     * 122%10=2 获得最后一个数=2,122/10=12                 1*10+2=12
     *
     * 终止条件：反转得到的数字大于等于正在操作的数字，就完成了反转
     * @param x
     * @return
     */
    public static boolean isPalindrome02(int x) {
        //如果x为负数或个位数为0的数一定不是回文数
        if(x<0||(x>0&&x%10==0)){
            return false;
        }
        int reverseNum=0;
        //当x小于或等于reverseNum时，反转完成
        while (x>reverseNum){
            reverseNum=reverseNum*10+x%10;
            x/=10;
        }

        //reverseNum%10==x考虑的是奇数的情况，reverseNum取多了一位，需要去掉再比较
        return reverseNum==x||reverseNum/10==x;
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
