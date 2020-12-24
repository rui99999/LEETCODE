package Math;

public class test326 {
    public static void main(String[] args) {
        System.out.println(Solution326.isPowerOfThree(-3));
    }
}
class Solution326 {
    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        n = Math.abs(n);
        if(n>0&&n<=3){
            return true;
        }
        while (n > 0) {
            if (n == 3) {
                return true;
            }
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}