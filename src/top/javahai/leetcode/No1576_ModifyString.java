package top.javahai.leetcode;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 *
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 * 示例 3：
 *
 * 输入：s = "j?qg??b"
 * 输出："jaqgacb"
 * @author Hai
 * @date 2020/10/7 - 12:31
 */
public class No1576_ModifyString {
    public static void main(String[] args) {
        String s = "?zs";
        String result = modifyString(s);
        System.out.println(result);
        System.out.println(modifyString( "j?qg??b"));
        System.out.println(modifyString("??yw?ipkj?"));

    }


    /**
     * 遍历字符，遇到？就使用不与前后字符相等的字符进行替换
     *
     *
     * 单独修改字符串的几个字符，可以将字符转化为字符数组，修改完成后String.valueOf()将字符数组转化回字符串
     *
     * @param s
     * @return
     */
    public static String modifyString(String s) {
        char[] chars = s.toCharArray();
        char front=' ';
        char rear=' ';
        char replaceChar='a';
        if (chars.length==1){
            chars[0]=replaceChar;
            return String.valueOf(chars);
        }
        for (int i = 0; i < chars.length; i++) {

            if (chars[i]=='?'){
                if (i==0){
                   rear=chars[i+1];
                }
                else if (i==chars.length-1){
                    front=chars[i-1];
                }else{
                    front=chars[i-1];
                    rear=chars[i+1];
                }
                while (replaceChar==front||replaceChar==rear){
                    replaceChar++;
                }
                chars[i]=replaceChar;
                //重置replaceChar，避免很多问号的情况，replaceChar加到后面不是字母了
                replaceChar='a';
            }
        }
        return String.valueOf(chars);

    }
}
