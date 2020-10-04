package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 题目：
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 * 
 * 示例 1：
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 *
 * 示例 2：
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 * @author Hai
 * @date 2020/8/15 - 23:24
 */
public class No748_ShortestCompletingWord {
    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words ={"step", "steps", "stripe", "stepple"};
        System.out.println(new No748_ShortestCompletingWord().shortestCompletingWord(licensePlate,words));
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans="";
        for (String word : words) {
            //比较符合要求的word，先找到第一个符合要求的word，后面大于这个word长度的都不进行匹配了
            if ((ans.length()==0||word.length()<ans.length())&&compareIntArr(target,count(word))){
                ans=word;
            }
        }
        return ans;
    }

    /**
     * 比较两个经count统计后的单词对应的int数组是否符合要求
     * licensePlateArr数组的每一位数都需要小于等于word的，word才是完整词
     * @param licensePlateArr
     * @param word
     * @return
     */
    public boolean compareIntArr(int[] licensePlateArr,int[] word){
        for (int i=0;i<26;i++){
            if (licensePlateArr[i]>word[i]){
                return false;
            }
        }
        return true;
    }
    /**
     * 计算单词含有的字母个数，使用int[] 表示0~25位代表不同的字母，数组不同位数上的值表示相同的字母个数
     * @param word
     * @return
     */
    public int[] count(String word){
        //int数组的初始值位0
        int[] result=new int[26];
        char[] chars = word.toLowerCase().toCharArray();
        for (char aChar : chars) {
            //字符运算，得到的数字代表字母字符本身
            int index=aChar-'a';
            if (index>=0&&index<26){
                result[index]++;
            }
        }
        return result;
    }
}
