package 链表;

public class test328 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        l1 = Solution328_2.oddEvenList(l1);
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
class Solution328_2 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode oddNow = odd;
        ListNode even = head.next;
        ListNode evenNow = even;
        while (evenNow != null && evenNow.next != null) {
            oddNow.next = oddNow.next.next;
            evenNow.next = evenNow.next.next;
            oddNow = oddNow.next;
            evenNow = evenNow.next;
        }
        oddNow.next = even;
        return odd;
    }
}