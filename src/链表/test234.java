package 链表;

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