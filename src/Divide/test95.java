package Divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test95 {
    public static void main(String[] args) {
        List<TreeNode> t = Solution95.generateTrees(3);
        System.out.println(t);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
class Solution95 {
    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generate(1,n);

    }

    public static List<TreeNode> generate(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }
        if (l == r) {
            return new ArrayList<TreeNode>() {{
                add(new TreeNode(l));
            }};
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generate(l, i - 1);
            List<TreeNode> right = generate(i+1, r);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}