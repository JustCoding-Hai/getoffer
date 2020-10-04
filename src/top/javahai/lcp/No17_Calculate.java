package top.javahai.lcp;

/**
 * @author Hai
 * @date 2020/9/24 - 22:57
 */
public class No17_Calculate {
    public int calculate(String s) {
        char[] charArray = s.toCharArray();
        int x=1;
        int y=0;
        for (char c : charArray) {
            if (c=='A'){
                x=2*x+y;
            }else{
                y=2*y+x;
            }
        }
        return x+y;
    }
}
