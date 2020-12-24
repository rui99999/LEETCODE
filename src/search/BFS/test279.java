package search.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test279 {
    public static void main(String[] args) {
        System.out.println(Solution279.numSquares(6));
    }
}
class Solution279 {
    public static int numSquares(int n) {
        List<Integer> squNums = getnums(n);
        Queue<Integer> queue = new LinkedList();
        boolean[] mark = new boolean[n+1];
        queue.add(n);
        mark[n] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.poll();
                for (Integer item : squNums) {
                    //当前节点能到达的节点是它自己减去一个平方数
                    int next = current - item;
                    if (next == 0) {
                        return ans;
                    }
                    if (next < 0) {
                        continue;
                    }
                    if (mark[next]) {
                        continue;
                    }
                    queue.add(next);
                    mark[next] = true;
                }

            }
        }
        return -1;
    }

    static List<Integer> getnums(int n) {
        List list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                list.add(i*i);
            }
        }
        return list;
    }
}