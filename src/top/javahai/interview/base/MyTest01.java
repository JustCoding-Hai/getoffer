package top.javahai.interview.base;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/18 - 10:44
 **/
public class MyTest01 {
    public static void main(String[] args) {
        //声明长度为3的数组
        int[][] arr = new int[3][];
        System.out.println(arr.length);
        Thread thread = new Thread(() -> {
            System.out.println("aa");
        });
//Thread类中没有exit()方法
//        thread.exit();

    }
}
