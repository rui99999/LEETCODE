package search.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test51 {
    public static void main(String[] args) {
        Solution51 s = new Solution51();
        System.out.println(s.solveNQueens(2));
    }
}
class Solution51 {
    Set<Integer> bias1;
    Set<Integer> bias2;
    Set<Integer> col;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        bias1 = new HashSet<>();
        bias2 = new HashSet<>();
        ans = new ArrayList<>();
        col = new HashSet<>();
        int[] queue = new int[n];
        dfs(0,n,new int[n]);
        return ans;
    }

    private void dfs(int row, int n,int[] queue) {
        if (row == n) {
            ans.add(generate(queue, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (bias1.contains(row + i) || bias2.contains(row - i) || col.contains(i)) {
                continue;
            }
            bias1.add(row + i);
            bias2.add(row - i);
            col.add(i);
            queue[row] = i;
            dfs(row+1,n,queue);
            queue[row] = -1;
            bias1.remove(row + i);
            bias2.remove(row - i);
            col.remove(i);
        }
    }

    public List<String> generate(int[] queue,int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (queue[i] != j) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}