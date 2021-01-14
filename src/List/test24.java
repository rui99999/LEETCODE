package List;

public class test24 {
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

        ListNode head = Solution24.swapPairs(l1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
class Solution24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head.next;
        head.next = ans.next;
        ans.next = head;
        ListNode per = head;
        ListNode now = per.next;
        while (now != null) {
            ListNode next = now.next;
            if (next == null) {
                break;
            }
            now.next = next.next;
            next.next = now;
            per.next = next;
            per = now;
            now = now.next;
        }
        return ans;
    }
}