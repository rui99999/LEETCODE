package Binary;

public class test69 {
    public static void main(String[] args) {

        System.out.println(Solution69.mySqrt(8));
    }
}
class Solution69 {
    static int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;

    }

}