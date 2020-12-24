package search.Backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test257 {
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null ) {
            return ans;
        }

        Deque<String> now = new LinkedList<>();
        dfs(ans, now, root);
        return ans;
    }

    private void dfs(List<String> ans, Deque<String> now, TreeNode root) {
        now.addLast(String.valueOf(root.val));
        if (root.right == null&&root.left==null) {
            ans.add(String.join("->",now));
            return;
        }
        if (root.left!=null) {
            dfs(ans, now, root.left);
        }
        if (root.right!=null) {
            dfs(ans, now, root.right);
        }
        now.removeLast();

    }
}