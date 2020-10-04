package top.javahai.leetcode;


/**
 *
 * 注意点：
 * 使用ForEach循环时给数组元素赋值，不能改变数组的元素，如：
 * public static void main(String [] args){
 * int [] arr={1,2,3,4,5};
 *        for(int a:arr){
 *             a=0;
 *             System.out.print(a);
 *        }
 *       System.out.print(“\n”+a[0]);
 * }
 * 运行结果：
 * 00000
 * 1
 * 问题
 *给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author Hai
 * @date 2020/8/31 - 0:03
 */
public class No557_ReverseWords {
    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        System.out.println(new StringBuilder("sdc").reverse().toString());
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
//        for (String str : split) {
//            str= new StringBuilder(str).reverse().toString();
//        }
        for (int i = 0; i < split.length; i++) {
            split[i]= new StringBuilder(split[i]).reverse().toString();
        }
        String result = String.join(" ", split);
        return result;
    }
}
