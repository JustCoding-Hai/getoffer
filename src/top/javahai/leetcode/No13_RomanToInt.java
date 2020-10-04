package top.javahai.leetcode;

import java.util.HashMap;

/**
 * @author Hai
 * @date 2020/9/2 - 0:19
 */
public class No13_RomanToInt {
    public static void main(String[] args) {
//        System.out.println(romanToInt("III"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IX"));
//        System.out.println(romanToInt("LVIII"));
//        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 另一种存储方式：提供方法，传入罗马字符，里面switch判断字符返回对应的数
     */
    static HashMap<Character, Integer> hashMap;
    static{
        //建立对应关系
        hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
    }
    public static int getNum(Character ch){
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    /**
     * 通过HashMap建立罗马字符与数值的对应关系
     * 遍历时考虑六种情况
     * @param s
     * @return
     */
    public  int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int sum=0;
        for (int i = 0; i < charArray.length; i++) {
            //如果是最后一位，直接计算
            if (i==charArray.length-1){
                sum+=getNum(charArray[i]);
                break;
            }
            //考虑六种特殊情况
            switch (charArray[i]){
                case 'I':
                    if (charArray[i+1]=='V'){
                        sum+=4;
                        i++; }
                    else if (charArray[i+1]=='X'){
                        sum+=9;
                        i++; }
                    else{
                        sum+=1;
                    }

                    break;
                case 'X':
                    if (charArray[i+1]=='L'){
                        sum+=40;
                        i++; }
                    else if (charArray[i+1]=='C'){
                        sum+=90;
                        i++; }
                    else{
                        sum+=10;
                    }
                    break;
                case 'C':
                    if (charArray[i+1]=='D'){
                        sum+=400;
                        i++; }
                    else if (charArray[i+1]=='M'){
                        sum+=900;
                        i++; }
                    else{
                        sum+=100;
                    }
                    break;
                default:
                    sum+=getNum(charArray[i]);
            }

        }
        return sum;

    }

}
