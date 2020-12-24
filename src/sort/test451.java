package sort;

import java.util.*;

public class test451 {

    public static void main(String[] arg) {
        Solution s1 = new Solution();
        Solution2 s2 = new Solution2();
        System.out.println(s2.frequencySort("aaBbbbvvbCcCcCc"));
    }
}
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Character>[] list = new ArrayList[s.length()+1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (list[frequency] == null) {
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(entry.getKey());
        }
        for (int i = list.length-1; i > 0; --i) {
            if (list[i] == null) {
                continue;
            }
            for (char c : list[i]) {
                for (int k = 0; k < i;++k) {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}
class Solution2 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Character character : map.keySet()) {
            queue.offer(character);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < map.get(queue.peek());++i) {
                res.append(queue.peek());
            }
            queue.poll();
        }
        return res.toString();

    }
}