package DP;

public class test70 {
    public static void main(String[] args) {
        System.out.println(Solution70.climbStairs(45));
    }
}

class Solution70 {
    static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}