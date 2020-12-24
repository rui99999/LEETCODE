package greedy;

import java.util.HashMap;
import java.util.Map;

public class test392 {
    public static void main(String[] args) {
        Solution392 s = new Solution392();
        System.out.println(s.isSubsequence("abc", "abcabcabc"));
    }
}
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (j < t.length()&&i<s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        return i == s.length();
    }
}