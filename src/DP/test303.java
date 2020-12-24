package DP;

public class test303 {
}
class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i] ;
    }
}
