package Math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class test628 {
    public static void main(String[] args) {
    }
}
 class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
