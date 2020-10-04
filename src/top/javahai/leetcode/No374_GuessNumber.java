package top.javahai.leetcode;

/**
 * 练习二分查找
 * @author Hai
 * @date 2020/8/20 - 22:50
 */
public class No374_GuessNumber {
    /**
     * 猜数字游戏的规则如下：
     *
     * 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。
     * 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
     *
     * -1 : 你猜测的数字比系统选出的数字大
     *  1 : 你猜测的数字比系统选出的数字小
     *  0 : 恭喜！你猜对了！
     * @return
     */
    public int guessNumber(int n) {
        int min=1;
        int max=n;
        int result=0;
        while (result==0){
            int middle=min+(max-min)/2;
            if (guess(middle)==-1){
                max=middle-1;
            }
            if (guess(middle)==1){
                min=middle+1;
            }
            if (guess(middle)==0){
                result=middle;
            }
        }
        return result;
    }

    private int guess(int middle) {
        return 0;
    }
}
