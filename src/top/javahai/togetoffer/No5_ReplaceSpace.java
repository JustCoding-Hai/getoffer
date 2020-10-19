package top.javahai.togetoffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hai
 * @date 2020/8/26 - 22:54
 */
public class No5_ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(new No5_ReplaceSpace().replaceSpace02("      "));
    }
    public String replaceSpace(String s) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(s);
        String result = matcher.replaceAll("%20");
        return result;
    }
    public String replaceSpace02(String s) {
        //return s.replace(" ","%20");
        return s.replaceAll("\\s","%20");
    }
    //toCharArray遍历字符，使用StringBuilder记录
}
