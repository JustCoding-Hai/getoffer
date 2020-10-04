package top.javahai.leetcode;

import javax.xml.ws.soap.Addressing;

/**
 * @author Hai
 * @date 2020/8/3 - 23:35
 */
public class No415_AddStrings {
  public static void main(String[] args) {
    System.out.println(addStrings("9","1"));
  }

  /**
   * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
   * 如果是1+9
   *
   * 提示：
   * num1 和num2 的长度都小于 5100
   * num1 和num2 都只包含数字 0-9
   * num1 和num2 都不包含任何前导零
   * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
   * @param num1
   * @param num2
   * @return
   */
  public static String addStrings(String num1, String num2) {
    /**
     * 解题思路：
     * 1.模拟现实的加法运算
     * 2.使用变量add记录当前位数的相加结果，%10后用于下一个位数的运算
     */
    //存放结果
    StringBuilder result = new StringBuilder();
    //起始位数
    int n1=num1.length()-1;
    int n2=num2.length()-1;
    //记录结果的余数
    int add=0;
    //add!=0用于最高位相加>10的情况
    while (n1>=0||n2>=0||add!=0){
      //通过字符获取数字：数字字符-'0'等于数字
      int x=n1>=0?num1.charAt(n1)-'0':0;
      int y=n2>=0?num2.charAt(n2)-'0':0;
      int temp=x+y+add;
      add=temp/10;
      n1--;
      n2--;
      result.append(temp%10);
    }
    StringBuilder reverse = result.reverse();
    return reverse.toString();
  }
}
