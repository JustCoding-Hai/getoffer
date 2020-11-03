package top.javahai.togetoffer;

/**
 * @author Hai
 * @program: getoffer
 * @description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @create 2020/10/27 - 23:31
 **/
public class No53_MissingNumber {
    /**
     * 考虑到数组的值分布均匀，所以使用插值查找算法
     *
     *
     *
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums.length==1&&nums[0]==0){
            return nums[0]+1;
        }
        if (nums.length==1&&nums[0]!=0){
            return nums[0]-1;
        }
        int range=nums.length;
        for (int i = 0; i <=range; i++) {
            int find = insertValueSearch(nums, 0, nums.length - 1, i);
            if(find==-1){
                return i;
            }
        }
        return -1;
    }
    public int insertValueSearch(int[] arr, int left, int right, int target) {
        //边界条件
        if (left > right || target < arr[left] || target > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] > target) {
            return insertValueSearch(arr, left, mid - 1, target);
        } else if (arr[mid] < target) {
            return insertValueSearch(arr, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    public int binarySearch(){
        return -1;
    }

}
