package top.javahai.lcp;

/**
 * @author Hai
 * @program: getoffer
 * @description: LCP 01. 猜数字
 * @create 2021/1/25 - 22:36
 **/
public class No1_Game {

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
