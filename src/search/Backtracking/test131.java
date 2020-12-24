package search.Backtracking;

import java.util.*;

public class test131 {
    public static void main(String[] args) {
        Solution131 s = new Solution131();
        System.out.println(s.partition("aab"));

    }
}

class Solution131 {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        }
        dfs(0,s,new ArrayDeque<>());
        return ans;
    }

    private void dfs(int begin,String s,Deque<String> path) {
        if (begin == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            if (!isRevers(s, begin, i )) {
                continue;
            }
            path.addLast(s.substring(begin, i + 1));
            dfs(i + 1, s, path);
            path.removeLast();

        }
    }

    private boolean isRevers(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}

//class Solution131 {
//    List<List<String>> ans;
//    public List<List<String>> partition(String s) {
//        ans = new ArrayList<>();
//        if (s.length() == 0) {
//            return ans;
//        }
//        dfs(s, new LinkedList<>());
//        return ans;
//    }
//
//    private void dfs(String s,Deque<String> path) {
//        if (0 == s.length()) {
//            ans.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 1; i <= s.length(); i++) {
//            String temp = s.substring(0, i);
//            if (!isRevers(temp)) {
//                continue;
//            }
//            path.addLast(temp);
//            dfs(s.substring(i), path);
//            path.removeLast();
//
//        }
//    }
//
//    public boolean isRevers(String s) {
//        StringBuffer sb=new StringBuffer(s);
//        return sb.reverse().toString().equals(s);
//    }
//
//}