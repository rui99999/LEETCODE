package search.DFS;

public class test494 {
    public static void main(String[] args) {
        Solution494 s = new Solution494();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
class Solution494 {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        dfs(0, S, nums, 0);
        return ans;
    }

    private void dfs(int index, int s,  int[] nums, int sum) {

        if (index == nums.length&&s == sum ) {
            ans++;
            return;
        }
        if (index == nums.length) {
            return;
        }

        dfs(index + 1, s,  nums,  sum + nums[index]);
        dfs(index + 1, s,  nums,  sum - nums[index]);
    }
}