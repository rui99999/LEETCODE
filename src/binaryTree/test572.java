package binaryTree;

public class test572 {
}
class Solution572 {
    TreeNode head;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return (dfs(s.left, t.left) && dfs(s.right, t.right))||(isSubtree(s.left, t) || isSubtree(s.right, t));

    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return dfs(s.left, t.left) && dfs(s.right, t.right);
        }
        return false;
    }
}