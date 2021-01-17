package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class test404 {
}
class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode head = queue.removeFirst();
                if (size % 2 == 0) {
                    if (head != null && head.right == null && head.left == null) {
                        ans += head.val;
                    }
                }
                if (head != null) {
                    queue.addLast(head.left);
                    queue.addLast(head.right);
                }
                size--;
            }
        }
        return ans;
    }
}
class Solution404_2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null & root.left.right == null) {
            sum = root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}