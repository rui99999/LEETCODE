package Math;

import java.math.BigInteger;
import java.util.Arrays;

public class test462 {
    public static void main(String[] args) {
        Solution462 s = new Solution462();
        System.out.println(s.minMoves2(new int[]{1,3,2}));
    }
}
class Solution462 {
    public  int minMoves2(int[] nums) {
        int index = findMid(nums, nums.length / 2);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - index);
        }
        return (int) ans;
    }

    private  int findMid(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int k = qp(nums, i, j);
            if (k == target) {
                break;
            }
            if (k < target) {
                i = k+1;
            } else {
                j = k-1;
            }
        }
        return nums[target];
    }

    private  int qp(int[] nums, int start, int end) {
        int i = start+1;
        int j = end;
        int cur = nums[start];
        while (i <= j) {
            while (i <= j && nums[i] < cur) {
                ++i;
            }
            while (i <= j && nums[j] > cur) {
                --j;
            }
            if (i <= j) {
                swap(nums, i, j);
                ++i;
                --j;
            }

        }
        swap(nums,start,j);
        return j;
    }

    public  void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}