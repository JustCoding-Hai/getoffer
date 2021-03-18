package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/18 - 10:52
 **/
public class MyTest02 {
    public static void main(String[] args) {
        int a = 1;
        int b = a++;
        int c = ++a;
        //3+5
        int d = a++ + ++a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
