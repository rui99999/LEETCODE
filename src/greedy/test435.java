package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class test435 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int[] ints : intervals) {
            if (ints[0] >= end) {
                end = ints[1];
                ++count;
            }
        }
        return intervals.length - count;
    }
}