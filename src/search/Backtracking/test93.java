package search.Backtracking;

import java.util.*;

public class test93 {
    public static void main(String[] args) {
        System.out.println(Solution93.restoreIpAddresses("25525511135"));
    }
}
class Solution93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }
        Deque<String> now = new LinkedList<>();
        dfs(0,s,0,0,ans,now);
        Collections.reverse(ans);
        return ans;
    }

    public static void dfs(int lawer, String s,int endIndex,int startIndex,List<String> ans, Deque<String> now) {
        if (lawer == 4 && endIndex == s.length()) {
            //找到一个
            ans.add(String.join(".", now));
            return;
        }
        if (endIndex == s.length()) {
            return;
        }
        if (s.length() - endIndex > (4 - lawer) * 3 || s.length() - endIndex<(4 - lawer)) {
            //条件不符合，递归结束
            return;
        }

        for (int i = 0; i < 3; i++) {
            endIndex += 1;
            if (endIndex > s.length()) {
                continue;
            }
            int num = Integer.valueOf(s.substring(startIndex, endIndex));
            if (num > 255) {
                continue;
            }
            if (s.charAt(startIndex) == '0' && endIndex - startIndex > 1) {
                continue;
            }
            now.addLast(s.substring(startIndex, endIndex));
            dfs(lawer + 1, s, endIndex, endIndex, ans, now);
            now.removeLast();
        }

    }
}