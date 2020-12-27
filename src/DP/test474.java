package DP;

public class test474 {
    public static void main(String[] args) {
        Solution474 s = new Solution474();
        System.out.println(s.findMaxForm(new String[]{"10","0001","111001","1","0"},2,3));
    }
}
class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) {
            return 0;
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            int[] cnt = countZeroAndOne(strs[i-1]);
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j < cnt[0] || k < cnt[1]) {
                        //容量不足装不下,继承之前的结果
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        //容量充足，可选装或不装
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - cnt[0]][k - cnt[1]]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

}