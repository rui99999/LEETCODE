package search.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class test139 {
    public static void main(String[] args) {
        Solution139 s = new Solution139();
        System.out.println(s.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    }

}
class Solution139 {
    HashSet<String> set;
    boolean flag = false;
    boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        set = new HashSet<>(wordDict);
        memo = new boolean[s.length()];
        return dfs( s, 0);
    }

    boolean dfs(String s,int start) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start]) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            if (set.contains(s.substring(start, i+1)) && dfs(s, i+1)) {
                    return true;
            }
        }
        memo[start] = true;
        return false;

    }

}