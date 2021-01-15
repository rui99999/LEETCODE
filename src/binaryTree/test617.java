package binaryTree;

public class test617 {
}
class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;
        if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        if (t1 != null && t2 == null) {
            root = new TreeNode(t1.val );
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }
        if (t1 == null && t2 != null) {
            root = new TreeNode(t2.val );
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        }
        return root;
    }
}
class Solution617_2 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}