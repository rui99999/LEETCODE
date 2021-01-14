package List;

public class test21 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(23);
        ListNode l13 = new ListNode(23);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(3);
        l21.next = l22;
        l22.next = l23;
        ListNode ans = solutionbc.mergeTwoLists(l11, l21);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
class Solution21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode per = new ListNode();
        ListNode ans = null;
        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode();
            if (l1.val > l2.val) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (ans == null) {
                ans = newNode;
                ans.next = per;
            } else {
                per.val = newNode.val;
                per.next = new ListNode();
                per = per.next;
            }
        }
        while (l1 != null) {
            per.val = l1.val;
            l1 = l1.next;
            if (ans == null) {
                ans = per;
            }
            per.next = l1!=null?new ListNode():null;
            per = per.next;

        }
        while (l2 != null) {
            per.val = l2.val;
            l2 = l2.next;
            if (ans == null) {
                ans = per;
            }
            per.next = l2!=null?new ListNode():null;

            per = per.next;
        }
        return ans;
    }
}
class solutionbc {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}