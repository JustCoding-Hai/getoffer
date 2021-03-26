package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/25 - 23:10
 **/
public class InterviewDemo01 {

    public static void main(String[] args) {
        String str = "This is trussan's Chinese sit trussan";
        String subStr = "trussan";
        System.out.println(getReverseStr(str, subStr));
    }

    static String getReverseStr(String str, String subStr) {
        //String类没有提供Reverse方法，StringBuilder才有提供
        StringBuilder reverseStr = new StringBuilder(str).reverse();
        StringBuilder reSubStr = new StringBuilder(subStr).reverse();
        //String 提供了replace和replaceAll方法用于替代子字符串
        String result = reverseStr.toString().replaceAll(String.valueOf(reSubStr), subStr);
        return result;
    }
}
