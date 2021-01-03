package 链表;

import java.util.List;

public class test160 {
}
 class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : a.next;
        }
        return a;
    }
}