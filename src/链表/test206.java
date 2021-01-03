package 链表;

public class test206 {
}
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode next = head.next;
        ListNode pre = head;
        pre.next = null;

        return getAns(next,pre);

    }

    public ListNode getAns(ListNode next, ListNode pre) {
        if (next == null) {
            return pre;
        }
        ListNode temp = next.next;
        next.next = pre;
        pre = next;
        next = temp;
        return getAns(next, pre);
    }
}