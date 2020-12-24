package DP;

public class test298 {
    public static void main(String[] args) {
        System.out.println(Solution298.numSquares(12));
    }
}
class Solution298 {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j*j <=i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}