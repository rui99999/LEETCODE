package DP;

public class test91 {
    public static void main(String[] args) {
        System.out.println(Solution91.numDecodings("27"));
    }
}
class Solution91 {
    public static int numDecodings(String s) {
        if (s.length()==0||s.charAt(0)=='0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')
                    dp[i] = i ==1?1:dp[i - 2];
                else return 0;

            }
            else if (s.charAt(i - 1) == '1') {
                dp[i] = i ==1?2:dp[i - 1] + dp[i - 2];
            }
            else if (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                dp[i] = i ==1?2:dp[i - 1] + dp[i - 2];
            }
            dp[i] = dp[i - 1];
        }
        return dp[s.length() - 1];

    }

    private boolean isARF(String s) {
        if (Integer.valueOf(s) <= 26) {
            return true;
        }
        return false;
    }
}