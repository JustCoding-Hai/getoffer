package top.javahai.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * @author Hai
 * @date 2020/8/12 - 23:08
 */
public class No728_SelfDividingNumbers {
    public static void main(String[] args) {
        //java标识符额可以以_，$,￥开头
        int _a;
        int _1;
        int $2;
        int ￥a;
        System.out.println(new No728_SelfDividingNumbers().selfDividingNumbers(1,22));
    }
    /**
     * 1.遍历left和right
     * 2.
     *
     * 数字字符-‘0’等于本身数字值
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i=left;i<=right;i++){
            String s=String.valueOf(i);
            char[] chars = s.toCharArray();
            if (chars.length==1){
                resultList.add(i);
                continue;
            }
            boolean flag=true;
            for (int i1 = 0; i1 < chars.length; i1++) {
               // int temp=Integer.valueOf(String.valueOf(chars[i1]));
                int temp=chars[i1]-'0';
                if(temp==0||i%temp!=0){
                    flag=false;
                };
            }
            if (flag){
                resultList.add(i);
            }
        }
        return resultList;
    }
}
