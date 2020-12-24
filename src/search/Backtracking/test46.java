package search.Backtracking;

import java.util.*;

public class test46 {

    public static void main(String[] args) {

        Solution46 s = new Solution46();
        System.out.println(s.permute(new int[]{}));
    }
}
class Solution46 {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        dfs(0,nums,new LinkedList<>(),new boolean[nums.length+1]);
        return ans;
    }

    public  void dfs(int index, int[] nums, Deque<Integer> now,boolean[] mark) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(now));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (mark[i]) {
                continue;
            }
            now.addLast(nums[i]);
            mark[i] = true;
            dfs(index+1, nums, now,mark);
            now.removeLast();
            mark[i] = false;
        }
    }
}