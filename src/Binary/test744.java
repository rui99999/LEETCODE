package Binary;
public class test744 {
    public static void main(String[] args) {

        System.out.println(Solution744.nextGreatestLetter(new char[]{'c','f','j'},
                'k'));
}
}
//class Solution {
//    public static char nextGreatestLetter(char[] letters, char target) {
//        int ans = 0;
//        int l=0;
//        int r = letters.length - 1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (letters[mid] == target) {
//                if (mid == letters.length - 1) {
//                    return letters[0];
//                }
//                while (letters[mid] == target) {
//                    if (mid == letters.length - 1) {
//                        return letters[0];
//                    }
//                    ++mid;
//                }
//                return letters[mid];
//            }
//            if (letters[mid] > target) {
//                ans = mid;
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return letters[ans];
//    }
//}

class Solution744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid+1;
            } else {
                r = mid ;
            }
        }
        return letters[l] == target || letters[l] < target ? letters[0] : letters[l];

    }
}