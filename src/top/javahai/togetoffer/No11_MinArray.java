package top.javahai.togetoffer;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * @create 2021/2/27 - 16:43
 **/
public class No11_MinArray {


    /**
     * 数组：
     * [3,3,3,1]
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int left = 0;
        int right = numbers.length - 1;
        //如果数组没有旋转
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] == numbers[right]) {
                right--;
            }
        }
        return numbers[left];
    }
}
