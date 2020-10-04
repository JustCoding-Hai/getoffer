package top.javahai.leetcode;

import sun.plugin.dom.exception.WrongDocumentException;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Hai
 * @date 2020/8/22 - 22:44
 */
public class No500_findWords {
    public static void main(String[] args) {
        String[] strings = {"asdfghjklASDFGHJKLqwertyuiopQWERTYUIOP","qwertyuiopQWERTYUIOP","qwertyuiopQWERTYUIOPzxcvbnmZXCVBNM"};
        String[] words = new No500_findWords().findWords(strings);
        for (String word : words) {
            System.out.println(word);
        }
    }

    /**
     *问题：
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示
     * 输入: ["Hello", "Alaska", "Dad", "Peace"]
     * 输出: ["Alaska", "Dad"]
     *
     * 解决：
     * 1.使用HashSet存储三行数据
     * 2.判断每个字符串的第一个字母属于哪个集合
     * 3.往集合中添加字母，如果集合长度长了就不符合规范
     *
     * 注意：
     * 1.数组的toString方法没有重写，调用的Object的
     * 2.List转换为对应数组，以String为例
     * ArrayList.toArray(new String[list.size])
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        HashSet<Character> line01 = new HashSet<>();
        for (char c : "qwertyuiop".toCharArray()) {
            line01.add(c);
        }
        HashSet<Character> line02 = new HashSet<>();
        for (char c : "asdfghjkl".toCharArray()) {
            line02.add(c);
        }
        HashSet<Character> line03 = new HashSet<>();
        for (char c : "zxcvbnm".toCharArray()) {
            line03.add(c);
        }
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            String temp=word.toLowerCase();
            //先判断在哪一行
            boolean flag=false;
            if (line01.contains(temp.charAt(0))){
                flag=iterateRow(temp,line01);
            }
            if (line02.contains(temp.charAt(0))){
                flag=iterateRow(temp,line02);
            }
            if (line03.contains(temp.charAt(0))){
                flag=iterateRow(temp,line03);
            }
            if (flag) result.add(word);

        }
        return result.toArray(new String[result.size()]);
    }

    private boolean iterateRow(String word, HashSet<Character> line) {
        int size = line.size();
        for (char c : word.toCharArray()) {
            line.add(c);
            if (line.size()>size){
                //还原原本的line
                line.remove(c);
                return false;
            }
        }
        return true;
    }
}
