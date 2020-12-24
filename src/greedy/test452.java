package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class test452 {
    public static void main(String[] args) {
        Solution452 s = new Solution452();
        System.out.println(s.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
//        System.out.println(-2147483645-2147483647);

    }
}
class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[1];
                int b = o2[1];
                if (a > b) {
                    return 1;
                }
                if (a == b) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                ++count;
                end = point[1];
            }
        }
        return count;

    }
}

