package search.Backtracking;

import java.util.*;

public class test39 {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        System.out.println(s.combinationSum(new int[]{2,3,5},8));
    }
}
class Solution39 {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        dfs(target, new LinkedList<>(),0,candidates,0);
        return ans;
    }

    private void dfs(int target, Deque<Integer> path,int sum,int[] candidates,int begin) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(target, path, sum + candidates[i], candidates,i);
            path.removeLast();
        }
    }
}