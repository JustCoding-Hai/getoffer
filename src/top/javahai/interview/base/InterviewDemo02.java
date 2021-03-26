package top.javahai.interview.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/25 - 23:12
 **/
public class InterviewDemo02 {

    public static void main(String[] args) {
        InterviewDemo02 data = new InterviewDemo02();

        new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                data.first();
            }
        }).start();
        new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                data.second();
            }
        }).start();
        new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                data.third();
            }
        }).start();

    }

    private int num = 1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    private void first() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            System.out.println("first");
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println("second");
            num = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            System.out.println("third");
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
