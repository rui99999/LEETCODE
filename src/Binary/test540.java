package Binary;

public class test540 {
    public static void main(String[] args) {
        System.out.println(Solution540.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
class Solution540 {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            mid = mid % 2 == 0 ? mid : mid-1;
            //让mid指向偶数下标
            if (nums[mid] == nums[mid + 1]) {
                l = mid+2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}