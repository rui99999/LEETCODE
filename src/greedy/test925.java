package greedy;

public class test925 {
    public static void main(String[] args) {
        System.out.println(Solution925.isLongPressedName("alex", "alexxr"));
    }

}
class Solution925 {
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while ( j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                ++i;
                ++j;
            } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
                ++j;
            } else {
                return false;
            }


        }

        return i == name.length();
    }
}