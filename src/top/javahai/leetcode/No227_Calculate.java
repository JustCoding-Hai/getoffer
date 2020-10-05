package top.javahai.leetcode;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * @author Hai
 * @date 2020/10/5 - 0:02
 */
public class No227_Calculate {
    public static void main(String[] args) {
        String str="3+2*20";
        System.out.println("1+3"+'4');
        System.out.println(calculate("300+2*12"));
    }
    public static int calculate(String s) {
        if (s.equals("")||s==null){
            return 0;
        }
        s=s.replaceAll("\\s+","");

        List<String> postfixExpression = toPostfixExpression(s);

        for (String s1 : postfixExpression) {
            System.out.print(s1+" ");
        }
        System.out.println();

        return evalRPN(postfixExpression);
    }

    /**
     * 将中缀表达式转化为后缀表达式数组
     * "3+2*2"
     * "3*2+2"
     * @param str
     * @return
     */
    public static List<String> toPostfixExpression(String str){
        //TODO 多位数的处理
        //运算符栈
        Stack<String> s1 = new Stack<>();
        //中间结果栈
        ArrayList<String> s2= new ArrayList<>();
        //遍历字符串的指针
        int index=0;
        while (index<=str.length()-1){
            String s=String.valueOf(str.charAt(index));
            if (!s.matches("\\d")){
                while (s1.size()!=0&&operation(s)<=operation(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(s);
                index++;
            }
            //如果是数字需要往后看，考虑多位数的情况
            else{
                String num=s;
                if (index==str.length()-1){
                    s2.add(num);
                    index++;
                    continue;
                }
                while (Character.isDigit(str.charAt(index+1))){
                    num=num+str.charAt(index+1);
                    index++;
                    if (index==str.length()-1){
                       break;
                    }
                }
                s2.add(num);
                index++;
            }
        }
        //将s1的运算符弹出到s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 计算数组存储的后缀表达式
     * @param tokens
     * @return
     */
    public static int evalRPN(List<String> tokens) {
        if (tokens==null||tokens.size()==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num1=0;
        int num2=0;
        for (String token : tokens) {
            switch (token){
                case "+":
                    num1= stack.pop();
                    num2= stack.pop();
                    stack.push(num1+num2);
                    break;
                case "-":
                    num1= stack.pop();
                    num2= stack.pop();
                    stack.push(num2-num1);
                    break;
                case "*":
                    num1= stack.pop();
                    num2= stack.pop();
                    stack.push(num1*num2);
                    break;
                case "/":
                    num1= stack.pop();
                    num2= stack.pop();
                    stack.push(num2/num1);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    /**
     * 返回操作数的优先级
     * @param c
     * @return
     */
    public static int operation(String c){
        switch (c){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                System.out.println("这不是一个数");
        }
        return 0;
    }
}
