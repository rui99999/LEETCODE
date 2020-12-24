package search.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class test17 {
    public static void main(String[] args) {
        System.out.println(Solution17.letterCombinations(""));
    }
}
class Solution17 {
    public static List<String> letterCombinations(String digits) {
        int count = digits.length();
        List<String> res = new ArrayList<>();
        List<String> bx = new ArrayList<>();
        if (count == 0) {
            return res;
        }
        String[] abc = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < count; i++) {

            bx.add(abc[Integer.valueOf(String.valueOf(digits.charAt(i)))]);
        }
        StringBuffer now = new StringBuffer();
        dfs(0, digits, res, now, bx);
        return res;
    }

    static void dfs(int index,String digits,List<String> res,StringBuffer now,List<String> bx) {
        if (index == digits.length()) {
            res.add(now.toString());
            return;
        }
        String indexNow = bx.get(index);
        for (int i = 0; i < indexNow.length(); i++) {
            now.append(indexNow.charAt(i));
            dfs(index + 1, digits, res, now, bx);
            now.deleteCharAt(index);
        }
    }
}