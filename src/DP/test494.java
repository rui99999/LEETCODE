package DP;

public class test494 {
}
class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (nums.length == 0) {
            return 0;
        }
        if (Math.abs(S) > Math.abs(sum)) {
            return 0;
        }
        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][sum + nums[0]] = dp[0][sum - nums[0]] = 1;
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                int l = j - nums[i] < 0 ? 0 : j - nums[i];
                int r = j + nums[i] > sum * 2 ? 0 : j + nums[i];
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[nums.length - 1][sum + S];
    }
}