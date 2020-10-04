package top.javahai.leetcode;

import java.util.Stack;

/**
 * @author Hai
 * @date 2020/10/4 - 13:07
 */
public class No150_EvalRPN {
    public static void main(String[] args) {
        String[] arr={"4","13","5","/","+"};
        String[] arr2={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN_v2(arr));
        System.out.println("13".matches("\\d"));
        System.out.println("-13".matches(".\\d+"));
        System.out.println("13".matches(".\\d+"));
        System.out.println("4".matches("-\\d+|\\d+"));
        System.out.println(1+-11);
    }


    /**
     * 根据 逆波兰表示法，求表达式的值。
     *
     * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 问题：这里栈中转String没有必要
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        if (tokens==null||tokens.length==0){
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("\\d+")){
                stack.push(token);
            }else{
                Integer result=0;
                Integer num1=Integer.valueOf(stack.pop());
                Integer num2=Integer.valueOf(stack.pop());
                switch (token){
                    case "+":
                        result=num1+num2;
                        break;
                    case "-":
                        result=num2-num1;
                        break;
                    case "*":
                        result=num1*num2;
                        break;
                    case "/":
                        result=num2/num1;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.valueOf(stack.pop());
    }
    //TODO 改良在一个switch中写完
    public static int evalRPN_v2(String[] tokens) {
        if (tokens==null||tokens.length==0){
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


}
