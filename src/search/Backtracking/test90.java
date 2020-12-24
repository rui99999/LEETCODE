package search.Backtracking;

import java.util.*;

public class test90 {
    public static void main(String[] args) {
        Solution90 s = new Solution90();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2,2}));
    }
}
class Solution90 {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0) {
            return ans;
        }
        dfs(0,nums.length,new LinkedList<Integer>(),0,nums);
        return ans;
    }

    private void dfs(int index, int len, Deque path,int begin,int[] nums) {
        if (index <= len) {
            ans.add(new ArrayList<>(path));

        }
        if (index > len) {
            return;
        }

        for (int i = begin; i < len; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            dfs(index+1,len,path,i+1,nums);
            path.removeLast();
        }
    }
}