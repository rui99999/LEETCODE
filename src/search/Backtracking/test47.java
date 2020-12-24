package search.Backtracking;

import java.util.*;

public class test47 {
    public static void main(String[] args) {

        Solution47 s = new Solution47();
        System.out.println(s.permuteUnique(new int[]{1,1,2}));
    }
}
class Solution47 {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        //排序，让相同元素相邻
        Arrays.sort(nums);
        dfs(0,nums,new boolean[nums.length],new LinkedList<>());
        return ans;
    }

    private void dfs(int index, int[] nums, boolean[] mark, Deque<Integer> now) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(now));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
//            !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !mark[i - 1]) {
                continue;
            }
            mark[i] = true;
            now.addLast(nums[i]);
            dfs(index+1,nums,mark,now);
            now.removeLast();
            mark[i] = false;
        }
    }
}