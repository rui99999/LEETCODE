package List;

import java.util.ArrayDeque;
import java.util.Deque;

public class test234 {
}
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            if (stack.getFirst().equals(stack.getLast())) {
                if (stack.size() > 1) {
                    stack.pollFirst();
                }
                stack.pollLast();
            } else {
                return false;
            }
        }
        return true;
    }
}
class Solution234_2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode index = reverse(slow);
        while (head != slow) {
            if (head.val != index.val) {
                return false;
            }
            head = head.next;
            index = index.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = reverse(next);
        next.next = head;
        head.next = null;
        return newNode;
    }
}