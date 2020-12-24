package search.Backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test77 {
    public static void main(String[] args) {
        Solution77 s = new Solution77();
        System.out.println(s.combine(4, 2));

    }
}
class Solution77 {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        if (k == 0 || n == 0) {
            return ans;
        }
        dfs(0,k,new LinkedList<>(),n,1);
        return ans;
    }

    public  void dfs(int index, int k, Deque<Integer> now,int n,int i) {
        if (index == k) {
            ans.add(new ArrayList<>(now));
            return;
        }
        for (; i <= n; i++) {
            if (i>n - (k - now.size()) + 1) {
                continue;
            }
            now.addLast(i);
            dfs(index + 1, k, now, n,i+1);
            now.removeLast();

        }
    }
}