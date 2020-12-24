package sort;

import java.util.Arrays;

public class test75 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
class Solution3 {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for (int i : nums) {
            switch (i) {
                case 0:
                    ++r;
                    break;
                case 1:
                    ++w;
                    break;
                case 2:
                    ++b;
                    break;
            }
        }
        int idx = 0;
        for (int i = 0; i < r; ++i) {
            nums[idx++] = 0;
        }
        for (int i = 0; i < w; ++i) {
            nums[idx++] = 1;
        }
        for (int i = 0; i < b; ++i) {
            nums[idx++] = 2;
        }
    }
}
class Solution4 {
    public void sortColors(int[] nums) {
        int p0=0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                swap(nums, index++, p0++);
            } else if (nums[index] == 1) {
                ++index;
            } else {
                swap(nums,index,p2--);
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
