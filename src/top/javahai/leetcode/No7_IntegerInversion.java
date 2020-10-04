package top.javahai.leetcode;

import javax.xml.transform.Result;

/**
 * @author Hai
 * @date 2020/8/4 - 21:48
 */
public class No7_IntegerInversion {
  public static void main(String[] args) {
    System.out.println(reverse(123));
    System.out.println(reverse(120));
    System.out.println(reverse(-120));
    System.out.println(reverse(-124));
    System.out.println(reverse(0));
    System.out.println(reverse(1054));
  }
  /**
   * 1.将x转化为String
   * 2.反向遍历字符串
   * 3.用StringBuilder存放结果
   * 4.转化回int
   * @param x
   * @return
   */
  public static int reverse(int x) {
    String str=String.valueOf(x);
    StringBuilder builder=new StringBuilder();
    for (int i=str.length()-1;i>=0;i--){
      char c = str.charAt(i);
      if (c=='0'&&i==str.length()-1){
        continue;
      }
      if (c=='-'){
        //StringBuilder的insert方法用于指定位置插入
        builder.insert(0,c);
      }
      else{
        builder.append(c);
      }
    }
    Integer result=0;
    try {
     result= Integer.valueOf(builder.toString());
    }catch (Exception e){
      //e.printStackTrace();
    }
    return result;
  }
}
