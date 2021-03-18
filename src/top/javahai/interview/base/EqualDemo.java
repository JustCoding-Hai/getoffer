package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/17 - 18:03
 **/
public class EqualDemo {
    public static void main(String[] args) {
        int i = 10;
        long j = 10L;
        double d = 10.0;
        System.out.println(i == j);
        System.out.println(j == d);
        System.out.println(i == d);
    }
}
