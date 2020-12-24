package search.BFS;

import java.util.*;

public class test127 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        System.out.println(Solution127.ladderLength("hit", "bog", wordList));
    }
}
class Solution127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> marked = new HashSet<>();
        int ans = 1;
        queue.add(beginWord);
        marked.add(beginWord);
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                List<String> rote = gengtate(current, wordList);
                if (rote.size() == 0) {
                    continue;
                }
                for (String s : rote) {
                    if (s.equals(endWord)) {
                        return ans;
                    }
                    if (marked.contains(s)) {
                        continue;
                    }
                    marked.add(s);
                    queue.add(s);
                }
            }
        }
        return 0;
    }

    private static List<String> gengtate(String current, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String s : wordList) {
            if (isStr(current, s)) {
                //如果current和S相差一位，判定这俩之间有路径
                res.add(s);
            }
        }
        return res;
    }

    private static boolean isStr(String current, String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (current.charAt(i) != s.charAt(i)) {
                sum++;
            }
        }
        return sum == 1;
    }
}