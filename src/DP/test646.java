package DP;

import java.util.Arrays;

public class test646 {
}
class Solution646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int[] dp = new int[pairs.length];
        int ans = 0;
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][0] < pairs[i][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}