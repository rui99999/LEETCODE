package greedy;

import java.util.Arrays;

public class test455 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findContentChildren(new int[]{1, 2}, new int[]{3,1}));
    }

}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int res = 0;
        while (i<g.length&&j<s.length) {
            if (g[i] <= s[j]) {
                ++res;
                ++i;
                ++j;
                continue;
            }
            ++j;

        }
        return res;
    }
}