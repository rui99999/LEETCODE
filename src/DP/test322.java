package DP;

import java.util.Arrays;

public class test322 {
    public static void main(String[] args) {

    }
}
class Solutiondfs {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        dfs(coins, amount,0,0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[] coins, int amount,long sum,int count) {
        if (sum == amount) {
            ans = Math.min(ans, count);
        }
        if (sum > amount) {
            return;
        }
        for (int i = coins.length-1; i >=0; i--) {
            dfs(coins,amount,sum+coins[i],count+1);
        }
    }
}
class Solutiondp {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i < amount + 1; i++) {
                if (i < coin) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount];
    }
}