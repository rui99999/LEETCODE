package Binary;

public class test153 {
    public static void main(String[] args) {
        System.out.println(Solution153.findMin(new int[]{1,2}));
    }
}
class Solution153 {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}