package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/4/5 - 0:23
 **/
public class MyTest03 {
    static int[] arr = new int[10];

    /**
     * main方法的形参可以是任意的，不一定是args
     *
     * @param a
     */
    public static void main(String[] a) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr2 = new int[3];
        //错的定义方式：int[] arr2=new int[3]{1,2,3};
        int[] arr3 = {1, 2, 3};
        System.out.println("Hello World！");
        System.out.println(arr[1]);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 19; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MyThread");
        thread.start();

        System.out.println("结果：" + print(5420));
    }

    /**
     * 输出一个正整数的各个位数
     *
     * @param n
     */
    private static int print(int n) {
        int result = 0;
        while (n != 0) {
            System.out.println(n % 10);
            result += n % 10;
            n = n / 10;
        }
        return result;
    }

}
