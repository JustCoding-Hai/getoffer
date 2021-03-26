package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/26 - 20:53
 **/
public class InterviewDemo03 {
    public static void main(String[] args) {

        //WeakHashMap，HashMap都继承AbstractHashMap
        String str1 = "hello";
        String str2 = "hel" + "lo";
        System.out.println(str1 == str2);
    }
}
