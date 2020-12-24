package greedy;

import java.util.Arrays;

public class test53 {
    public static void main(String[] args) {
        Solution53 s = new Solution53();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            ans[i] = Math.max(ans[i - 1] + nums[i], nums[i]);
        }
        Arrays.sort(ans);
        return ans[ans.length - 1];
    }

}