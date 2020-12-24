package greedy;

public class test665 {
    public static void main(String[] args) {
        Solution665 s = new Solution665();
        System.out.println(s.checkPossibility(new int[]{1,4,1,2}));
    }
}
class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int x = 1;
        for (int i = 0; i < nums.length-1; ++i) {
            if (nums[i] > nums[i + 1]) {
                //出现非递减
                if (x == 1) {
                    //第一次改
                    --x;
                    if (i > 0) {
                        //防止i-1越界
                        if (nums[i + 1] >= nums[i - 1]) {
                            //优先更新第I个数，若不符合规定再修改第i+1个数
                            nums[i] = nums[i + 1];
                        } else {
                            nums[i + 1] = nums[i];
                        }
                    } else {
                        nums[i] = nums[i + 1];
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}