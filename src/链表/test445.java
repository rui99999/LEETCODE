package 链表;

import java.util.Deque;
import java.util.LinkedList;

public class test445 {
}
class Solution445    {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> ln1 = new LinkedList<>();
        Deque<Integer> ln2 = new LinkedList<>();
        while (l1 != null) {
            ln1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            ln2.addFirst(l2.val);
            l2 = l2.next;
        }
        ListNode last = null;
        ListNode now = null;
        int carry = 0;
        while (!ln1.isEmpty() && !ln2.isEmpty()) {
            int val = ln1.pollFirst() + ln2.pollFirst()+carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            } else {
                carry = 0;
            }
            now = new ListNode(val);
            now.next = last;
            last = now;
        }
        while (!ln1.isEmpty()) {
            int val = ln1.pollFirst() + carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            }else {
                carry = 0;
            }
            now = new ListNode(val);
            now.next = last;
            last = now;
        }
        while (!ln2.isEmpty()) {
            int val = ln2.pollFirst()+carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            }else {
                carry = 0;
            }
            now = new ListNode(val);
            now.next = last;
            last = now;
        }
        if (carry > 0) {
            now = new ListNode(carry);
            now.next = last;
        }
        return now;

    }
}