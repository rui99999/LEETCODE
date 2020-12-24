package Math;

public class test415 {
}
class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int cum = 0;
        while (i >= 0 || j >= 0) {
            int aa = i >= 0 ? num1.charAt(i) - '0' : 0;
            int bb = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = cum + aa + bb;
            if (temp > 9) {
                cum = temp/10;
                temp %= 10;
            } else cum = 0;
            ans.append(temp);
            --i;
            --j;
        }
        if (cum >0) {
            ans.append(cum);
        }
        return ans.reverse().toString();
    }
}