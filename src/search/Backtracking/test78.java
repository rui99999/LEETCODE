package search.Backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test78 {
    public static void main(String[] args) {
        Solution78 s = new Solution78();
        System.out.println(s.subsets(new int[]{1,2}));
    }
}
class Solution78 {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
//        ans.add(new ArrayList<>());
        if (nums.length == 0) {
            return ans;
        }
        dfs(nums.length,0,new LinkedList<>(),0,nums);
        return ans;
    }

    private void dfs(int len, int index, Deque<Integer> path,int begin,int[] nums) {
        if (index == len+1) {
            return;
        }
        ans.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {

            path.addLast(nums[i]);
            dfs(len, index + 1, path, i + 1, nums);
            path.removeLast();

        }

    }
}