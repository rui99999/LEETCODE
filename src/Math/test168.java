package Math;

public class test168 {
    public static void main(String[] args) {

        System.out.println(Solution.convertToTitle(52));
    }

}
class Solution {
    public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char)('A'+c-1));

            }
            n = n / 26;

        }
        return sb.reverse().toString();
    }
}