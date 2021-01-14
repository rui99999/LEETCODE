package 链表;

public class test328 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
//        l4.next = null;
        l1 = Solution328.oddEvenList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
class Solution328 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ansList = new ListNode(head.val);
        ListNode ans = ansList;
        ListNode index = head;
        ListNode per = new ListNode(-1);
        per.next = head;
        while (index != null && index.next != null && index.next.next != null) {
            ansList.next = new ListNode(index.next.next.val);
            ansList = ansList.next;
            index = index.next.next;
        }

        index = per;
        while (index != null && index.next != null && index.next.next != null) {
            ansList.next = new ListNode(index.next.next.val);
            ansList = ansList.next;
            index = index.next.next;
        }
        return ans;
    }
}