package top.javahai.interview.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Hai
 * @program: getoffer
 * @description:
 * @create 2021/3/28 - 19:50
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countScore(arr));

        Integer num1 = 127;
        int num2 = 300;
        Integer num3 = 127;
        System.out.println(num1 == num3);
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));
        HashMap<Object, Object> map = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ss");
    }

    static int countScore(int[] arr) {
        int res = 0;
        for (int i : arr) {
            res += i;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                res += (temp | arr[j]);
            }
        }
        return res;
    }
}
