package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/17 - 18:05
 **/
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("a");
        });
        thread.start();
        thread.start();
    }
}
