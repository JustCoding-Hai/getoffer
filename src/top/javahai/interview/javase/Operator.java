package top.javahai.interview.javase;

/**
 * @author Hai
 * @program: getoffer
 * @description: 自增运算符
 * @create 2021/1/30 - 10:10
 **/
public class Operator {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}

