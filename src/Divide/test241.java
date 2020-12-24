package Divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class test241 {
    public static void main(String[] args) {
        System.out.println(Solution241.diffWaysToCompute(""));
    }
}
class Solution241 {
    public static List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        if (isNumeric(input)) {
            return new ArrayList<Integer>(){{add(Integer.valueOf(input));}};
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            if (isOp(input.charAt(i))) {
                //如果是运算符，递归计算左边和右边所以可能的结果
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i ));
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1));
                res.addAll(comput(res1, res2, input.charAt(i)));
            }

        }
        return res;
    }

    static boolean isOp(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }

    static List<Integer> comput(List<Integer> res1, List<Integer> res2,char op) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < res1.size(); ++i) {
            for (int j = 0; j < res2.size(); ++j) {
                switch (op) {
                    case '+':
                        res.add(res1.get(i) + res2.get(j));
                        break;
                    case '-':
                        res.add(res1.get(i) - res2.get(j));
                        break;
                    case '*':
                        res.add(res1.get(i) * res2.get(j));
                        break;
                        default:
                }
            }
        }
        return res;
    }
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}