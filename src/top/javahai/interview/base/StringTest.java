package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/17 - 11:35
 **/
public class StringTest {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = "1" + "23";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.intern() == a);
    }
}
