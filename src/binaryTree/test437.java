package binaryTree;

public class test437 {
}
class Solution437 {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int res = sum == 0 ? 1 : 0;
        return res + dfs(root.left, sum) + dfs(root.right, sum);
    }
}