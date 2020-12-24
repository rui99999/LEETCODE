package Divide;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class test42 {
    static int[] dp;
    public static void main(String[] args) {

        System.out.println();
    }
}
class Solution {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }
}