package top.javahai.interview.thread;

import java.util.concurrent.Executors;

/**
 * @author Hai
 * @program: getoffer
 * @description: 线程池相关的demo
 * @create 2021/3/16 - 18:20
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(3);
//        ExecutorService executorService = new ExecutorService();
    }
}
