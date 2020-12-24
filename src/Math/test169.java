package Math;

import java.lang.reflect.Array;
import java.util.*;

public class test169 {
    public static void main(String[] args) {
        System.out.println(Solution169.majorityElement(new int[]{3,2,3}));
    }
}
class Solution169 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        return list.get(0).getKey();
    }
}