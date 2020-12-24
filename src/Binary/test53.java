package Binary;

public class test53 {
    public static void main(String[] args) {
        System.out.println(Solution53.missingNumber(new int[]{0, 1}));
    }
}
class Solution53 {
    public static int missingNumber(int[] nums) {
        int ans = 0;
        if (nums.length == 1 && nums[0] == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != ans) {
                return ans;
            }
            ++ans;
        }
        return ans++;
    }
}