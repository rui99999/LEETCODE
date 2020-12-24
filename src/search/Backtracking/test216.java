package search.Backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test216 {
    public static void main(String[] args) {
        Solution216 s = new Solution216();
        System.out.println(s.combinationSum3(3, 3));
    }
}
class Solution216 {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        if (k == 0 || n == 0) {
            return ans;
        }
        dfs(0,k,n,new LinkedList<>(),1);
        return ans;
    }

    private void dfs(int index,int k, int n, Deque<Integer> path,int begin) {
        if (n == 0 && index == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (n < 0) {
            return;
        }
        if (index == k+1) {
            return;
        }
        for (int j = begin; j < 10; j++) {
            if (n - j < 0) {
                break;
            }
            path.addLast(j);
            dfs(index+1,k,n-j,path,j+1);
            path.removeLast();
        }
    }
}
