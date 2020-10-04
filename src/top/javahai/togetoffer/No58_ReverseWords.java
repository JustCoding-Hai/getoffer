package top.javahai.togetoffer;

/**
 * @author Hai
 * @date 2020/8/10 - 22:38
 */
public class No58_ReverseWords {
    public static void main(String[] args) {
        String s1="the sky is blue";
        String s2= "  hello world!  ";
        String s3="a good   example";
        //System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        //System.out.println(reverseWords(s3));
        //System.out.println(s2.split("\\s+").length);
    }

    /**
     * 1.使用trim()方法去掉字符串前后的空格
     * 2.使用split("\\s+)分割字符串
     * 3.逆序遍历字符串数组，将结果放入StringBuilder中
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        //String[] split = s.trim().split("\\s+");
        String[] split = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            //System.out.println(split[i]);
            if (i==0){
                result.append(split[0]);
                break;
            }
            result.append(split[i]+" ");
        }
        return result.toString();
    }
}
