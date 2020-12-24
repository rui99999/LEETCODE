package Math;

public class test238 {
}
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= k;
            k *= nums[i];
        }
        return ans;
    }
}