package top.javahai.interview.collection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Hai
 * @program: getoffer
 * @description: 快速排序算法排序ArrayList
 * @create 2021/3/16 - 11:21
 **/
public class QuickSortListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.print("排序前：");
        list.forEach(System.out::print);
        quickSort(list);
        System.out.println();
        System.out.print("排序后：");
        list.forEach(System.out::print);
    }

    private static void quickSort(ArrayList<Integer> list) {
        //基准数
        Integer pivot = list.get(0);
        //放置小于基准值的元素
        ArrayList<Integer> smallList = new ArrayList<>();
        //放置大于等于基准值的元素
        ArrayList<Integer> bigList = new ArrayList<>();
        //遍历list，放置元素到这两个集合中
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < pivot) {
                smallList.add(list.get(i));
            } else {
                bigList.add(list.get(i));
            }

        }
        if (smallList.size() > 1) {
            quickSort(smallList);
        }
        if (bigList.size() > 1) {
            quickSort(bigList);
        }
        //清空原本的list的元素
        list.removeAll(list);
        //将小的元素先放入
        list.addAll(smallList);
        //放入基准数
        list.add(pivot);
        //将大的元素放入
        list.addAll(bigList);
    }
}
