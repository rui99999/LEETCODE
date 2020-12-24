package sort;

import java.util.*;

public class test347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution347.topKFrequent3(new int[]{4,1,-1,2,-1,2,3}, 2)));
    }
}
class Solution347 {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return map.get(o1) - map.get(o2);
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry.getKey());
            } else if (entry.getValue() > map.get(pq.peek())) {
                pq.poll();
                pq.add(entry.getKey());
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
    public static int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frent = entry.getValue();
            if (list[frent] == null) {
                list[frent] = new ArrayList<>();
            }
            list[frent].add(entry.getKey());
        }
        int index = 0;
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i]== null) {
                continue;
            }
            if (index >= k) {
                break;
            }
            for (int j = 0; j < list[i].size()&&index<k; j++) {
                ans[index++] = list[i].get(j);
            }
        }
        return ans;
    }
    public static int[] topKFrequent3(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }


}