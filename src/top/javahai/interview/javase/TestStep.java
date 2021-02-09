package top.javahai.interview.javase;

/**
 * @author Hai
 * @program: getoffer
 * @description: 递归求解走台阶问题
 * @create 2021/2/9 - 18:58
 **/
public class TestStep {

    public static void main(String[] args) {
        //统计耗费时间
        long begin01 = System.currentTimeMillis();
        System.out.println(f(40));
        long end01 = System.currentTimeMillis();
        System.out.println("递归耗费时间：" + (end01 - begin01) + "ms");

        long begin02 = System.currentTimeMillis();
        System.out.println(iterate(40));
        long end02 = System.currentTimeMillis();
        System.out.println("迭代耗费时间：" + (end02 - begin02) + "ms");
    }


    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n < -1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        } else {
            return f(n - 2) + f(n - 1);
        }
    }

    /**
     * 迭代实现
     *
     * @param n
     * @return
     */
    public static int iterate(int n) {
        if (n < -1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        //初始化为走一步台阶的走法数
        int one = 1;
        //初始化为走两步台阶的走法数
        int two = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

}
