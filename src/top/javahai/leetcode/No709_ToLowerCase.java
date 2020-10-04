package top.javahai.leetcode;

/**
 * @author Hai
 * @date 2020/8/19 - 22:33
 */
public class No709_ToLowerCase {
    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     *
     * 示例 1：
     * 输入: "Hello"
     * 输出: "hello"
     *
     * 解题：
     * 大写字母字符的ASCII码+32=对应的小写字母
     * @param str
     * @return
     */
//    public String toLowerCase(String str) {
//        return str.toLowerCase();
//    }
    public static String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        for(char c:str.toCharArray()){
            if (c>= 'A'&&c<='Z'){
                builder.append((char)(c+32));
            }else{
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Abc"));
    }
}
