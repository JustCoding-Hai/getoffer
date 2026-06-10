package top.javahai.leetcode;

import java.util.HashSet;

public class No128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                while (set.contains(++i)) {
                    count++;
                }
                if (count > result) {
                    result = count;
                }

            }


        }
        return result;
    }

}