package greedy;

public class test605 {
    public static void main(String[] args) {
        Solution605 s = new Solution605();
        System.out.println(s.canPlaceFlowers(new int[]{1, 0, 0, 0,0, 1}, 2));
    }
}
 class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
               flowerbed[i]=1;
                ++cnt;
            }
        }
        return cnt >= n;
    }
}