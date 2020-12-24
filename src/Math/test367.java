package Math;

public class test367 {
    public static void main(String[] args) {
        System.out.println(Solution367.isPerfectSquare(808201));
    }
}
class Solution367 {
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long l = 2;
        long r = num / 2;
        long mid = 0;
        long sqr = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            sqr = mid * mid;
            if (sqr == num) {
                return true;
            }
            if (sqr > num) {
                r = mid -1;
            } else {
                l = mid +1;
            }
        }
        return false;
    }
}