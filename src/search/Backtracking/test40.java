package search.Backtracking;

import java.util.*;

public class test40 {
    public static void main(String[] args) {
        Solution40 s = new Solution40();
        System.out.println(s.combinationSum2(new int[]{10,1,2,7,6,5}, 8));
    }
}
class Solution40 {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        if (candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,new LinkedList(),0);
        return ans;
    }

    private void dfs(int[] candidates, int target, Deque<Integer> path,int begin) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1] ) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], path, i + 1);
            path.removeLast();

        }

    }
}