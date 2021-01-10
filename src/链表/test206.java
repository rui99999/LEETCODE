package 链表;

public class test206 {
}
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = reverseList(next);
        next.next = head;
        head.next = null;
        return newNode;
    }

}