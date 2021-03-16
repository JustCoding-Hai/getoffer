package top.javahai.interview.collection;

import java.util.*;

/**
 * @author Hai
 * @program: getoffer
 * @description: 遍历Map的几种方式
 * @create 2021/3/16 - 16:02
 **/
public class TraverseMap {
    /**
     * 遍历Map的方式
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("1", "xiaohai1");
        hashMap.put("2", "xiaohai2");
        hashMap.put("3", "xiaohai3");
        hashMap.put("4", "xiaohai4");
        hashMap.put("5", "xiaohai5");
        System.out.println("(1)Lambda遍历：");
        hashMap.forEach((key, value) -> {
            System.out.print(key + ":" + hashMap.get(key) + " ");
        });
        System.out.println("\n(2)迭代器遍历");
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.print(key + ":" + hashMap.get(key) + " ");
        }
        System.out.println("\n(3)遍历Entry");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.print(entry.getKey() + ":" + hashMap.get(entry.getKey()) + " ");
        }
        System.out.println("\n(4)遍历keySet");
        for (String key : hashMap.keySet()) {
            System.out.print(key + ":" + hashMap.get(key) + " ");
        }
        System.out.println("\n(5)stream串行流遍历");
        hashMap.keySet().stream().forEach(key -> {
            System.out.print(key + ":" + hashMap.get(key) + " ");
        });
        System.out.println("\n(6)stream并行流遍历");
        hashMap.keySet().parallelStream().forEach(key -> {
            System.out.print(key + ":" + hashMap.get(key) + " ");
        });

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(System.out::println);

    }

    void test(int a, String... strings) {
        String[] clone = strings.clone();
    }
}
