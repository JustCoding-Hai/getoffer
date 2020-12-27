package top.javahai.lcp;


import com.sun.deploy.util.StringUtils;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2020/12/27 - 17:36
 **/
public class No10_05FindString {

    /**
     * 1.先获取所有没空的字符的数量
     * 2.建立二维稀疏数组
     * 3.二分查找符合的字符串
     * @param words
     * @param s
     * @return
     */
    public int findString(String[] words, String s) {
        int notBlankCount=0;
        for (String word : words) {
            if (!"".equals(word)){
                notBlankCount++;
            }
        }
        Object[][] notBlankWords = new Object[notBlankCount][2];
        int row=0;
        for (int i = 0; i < words.length; i++) {
            if (!"".equals(words[i])){
                notBlankWords[row][0]=i;
                notBlankWords[row][1]=words[i];
                row++;
            }
        }
        for (int i = 0; i < notBlankWords.length; i++) {
            if (s.equals(notBlankWords[i][1])){
                return (int) notBlankWords[i][0];
            }
        }
        return -1;
    }

    /**
     * 二分查找.有空的字符串影响二分查找
     * @param words
     * @param s
     * @return
     */
    public int findString2(String[] words, String s) {
        int left=0;
        int right=words.length-1;
        int mid;
        while (left<right){
            mid=(left+right)/2;
            int tempMid=mid;
            //如果是空字符串就向右移动一位
            while ("".equals(words[mid])&&mid<right){
                mid++;
            }
            //如果数组右边都是空字符串，就退回到原本mid的左边查找
            if (mid>right){
                right=tempMid-1;
                continue;
            }
            if (s.compareTo(words[mid])>0){
                left=mid+1;
            }else if (s.compareTo(words[mid])<0){
                right=mid-1;
            }else if (s.compareTo(words[mid])==0){
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("acv".compareTo("sb"));
        System.out.println("ccc".compareTo("aa"));
        System.out.println("ccc".compareTo("ccc"));
        System.out.println("".compareTo("ccc"));
    }
}
