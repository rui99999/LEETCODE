package Math;

import java.math.BigInteger;
import java.util.WeakHashMap;

public class test67 {
    public static void main(String[] args) {
        System.out.println(Solution67.addBinary("11","1"));
    }
}
class Solution67 {
    public static String addBinary(String a, String b) {
//        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
        StringBuffer ans = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int cum = 0;
        while (i >= 0 || j >= 0) {
            int aa = i >= 0 ? a.charAt(i) - '0' : 0;
            int bb = j >= 0 ? b.charAt(j) - '0' : 0;
            int temp = cum + aa + bb;
            if (temp > 1) {
                cum = 1;
                temp -= 2;
            } else cum = 0;
            ans.append(temp);
            --i;
            --j;
        }
        if (cum == 1) {
            ans.append('1');
        }
        return ans.reverse().toString();
    }
}