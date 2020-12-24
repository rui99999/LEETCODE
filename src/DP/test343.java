package DP;

public class test343 {
    public static void main(String[] args) {
        System.out.println(Solution343.integerBreak(10));
    }
}
class Solution343 {
    public static int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int tempMax = 0;
            for (int j = 1; j < i; j++) {
                tempMax = Math.max(tempMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = tempMax;
        }
        return dp[n];
    }
}