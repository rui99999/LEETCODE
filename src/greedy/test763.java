package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test763 {
    public static void main(String[] args) {
        Solution763 s = new Solution763();
        System.out.println(s.partitionLabels(""));
    }
}
class Solution763 {
    public List<Integer> partitionLabels(String S) {
        List res = new ArrayList();
        if (S.length() == 0 || S.equals(" ")) {
            res.add(0);
            return res;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            map.put(S.charAt(i), i);
        }
        int start = 0;
        int end = -1;

        while (end < S.length()-1) {
            start = end + 1;
            end= map.get(S.charAt(start));
            for (int i = start; i < end; ++i) {
                if (map.get(S.charAt(i))>end) {
                    end = map.get(S.charAt(i));
                }
            }
            res.add(end - start + 1);
        }
        return res;
    }
}