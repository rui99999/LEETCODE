package 链表;

public class test83 {
}
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode per = head;
        ListNode now = head.next;
        while (now != null) {
            if (now.val == per.val) {
                per.next = now.next;
                now = now.next;
            } else {
                per = per.next;
                now = now.next;
            }
        }
        return head;
    }
}