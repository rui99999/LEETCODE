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
        //因为有负值所以，列数加上负数
        int[][] dp = new int[nums.length][sum * 2 + 1];
        //0+num[0]和0-num[0]都有一种路径
        dp[0][sum + nums[0]] = dp[0][sum - nums[0]] = 1;
        if (nums[0] == 0) {
            //如果num[0]=0，+0-0都可达，所以两种
            dp[0][sum] = 2;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                //l和r代表dp[i - 1][j - nums[i]]和dp[i - 1][j + nums[i]]
                //如果有越界情况则说明不能从j - nums[i]到达j，这条路不可达，路线数量为0
                int l = 0;
                int r = 0;
                if (j - nums[i] >= 0) {
                    l = dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] <= sum * 2) {
                    r = dp[i - 1][j + nums[i]];
                }
                dp[i][j] = l + r;
            }
        }
        return dp[nums.length - 1][sum + S];
    }
}