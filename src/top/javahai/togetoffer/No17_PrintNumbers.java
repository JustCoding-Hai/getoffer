package top.javahai.togetoffer;

/**
 * @author Hai
 * @date 2020/8/27 - 23:05
 */
public class No17_PrintNumbers {
    public static void main(String[] args) {
        int[] numbers = printNumbers02(3);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
    /**
     *      * 1 9
     *      * 2 99
     *      * 3 999
     *
     * 10^2+10^1
     * 问题：
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * 示例 1:
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     * 说明：
     * 用返回一个整数列表来代替打印,n 为正整数
     */
    /**
     * 1.首先确定数组的大小
     * 2.依次赋值
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
        int temp=0;
        while (n>0){
            temp= temp+(int) Math.pow(10,n-1);
            n--;
        }
        temp=temp*9;
        int[] result = new int[temp];
        int j=1;
        for (int i = 0; i < result.length; i++) {
            if (j>temp){
                break;
            }
           result[i]=j++;
        }
        return result;
    }

    /**
     * 改进写法
     * @param n
     * @return
     */
    public static int[] printNumbers02(int n) {
        int size= (int) (Math.pow(10,n)-1);
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i]=i+1;
        }
        return result;
    }
}
