package Binary;

import java.util.Arrays;

public class test34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution34.searchRange(new int[]{}, 10)));
    }
}
class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{first(nums,target), last(nums,target)};
    }

    static int first(int[] nums, int t) {
        int l=0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < t) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return nums[l] == t ? l : -1;
    }

    static int last(int[] nums, int t) {
        int l=0;
        int r = nums.length-1 ;
        while (l < r) {
            int mid = l + (r - l+1) / 2;
            if (nums[mid] <= t) {
                l = mid ;
            } else {
                r = mid-1;
            }

        }
        return nums[l] == t ? l: -1;
    }
}