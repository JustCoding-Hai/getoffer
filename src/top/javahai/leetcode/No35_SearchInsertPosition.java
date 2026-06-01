package top.javahai.leetcode;

public class No35_SearchInsertPosition {
    public static void main(String[] args) {
        int i = 1/2;
        System.out.println(i);
    }

    public  static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        if (target <= nums[start]) {
            return start;
        }
        if (target >= nums[end]) {
            return end;
        }
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return end + 1;
    }
}
