package binaryTree;

public class test554 {
}
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDeep(root);
        return max;
    }

    public int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDeep(root.left);
        int r = getDeep(root.right);
        max = Math.max(l + r, max);
        return Math.max(l, r) + 1;
    }
}