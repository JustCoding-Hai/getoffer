package top.javahai.interview.javase;

import java.util.Arrays;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/2/9 - 18:27
 **/

public class Demo04 {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);
        System.out.println("main方法：");
        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("my.a = " + my.a);
    }

    public static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
        System.out.println("change方法：");
        System.out.println("j = " + j);
        System.out.println("s = " + s);
        System.out.println("n = " + n);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("m.a = " + m.a);

    }
}

class MyData {
    int a = 10;
}
