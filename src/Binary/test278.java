package Binary;

public class test278 {
    public static void main(String[] args) {
        System.out.println(Solution278.firstBadVersion(100));
    }
}
 class VersionControl{
     static boolean isBadVersion(int version) {
         if (version >= 100) {
             return true;
         }
         return false;
     }
 }
class Solution278 extends VersionControl {
    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}