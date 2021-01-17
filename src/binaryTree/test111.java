package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class test111 {
}
class Solution111 {
    public int minDepth(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode head = queue.removeFirst();
                if (head != null && head.left == null && head.right == null) {
                    return ans;
                }
                if (head.left != null) {
                    queue.addLast(head.left);
                }
                if (head.right != null) {
                    queue.addLast(head.right);
                }
            }
        }
        return 0;
    }
}
class Solution111_2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left == 0 ? right + 1 : left + 1;
        }
        return Math.min(left, right) + 1;

    }
}