package DP;

public class teat198 {


    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int per = 0;
            int current = 0;
            for (int num : nums) {
                int temp = Math.max(current, per + num);
                per = current;
                current = temp;
            }
            return current;
        }
    }

}
