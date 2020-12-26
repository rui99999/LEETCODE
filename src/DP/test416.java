package DP;

public class test416 {
}
class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum / 2 + 1; j++) {
                if (j == nums[i]) {
                    dp[i][j] = true;
                }
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][sum / 2];

    }
}