package greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test406 {
    public static void main(String[] args) {
        Solution406 s = new Solution406();
        System.out.println(Arrays.deepToString(s.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
    static class Solution406 {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }
            });
            List<int[]> list = new ArrayList<>();
            for (int[] person : people) {
                list.add(person[1],person);
            }
            return list.toArray(new int[people.length][]);
        }
    }
}
