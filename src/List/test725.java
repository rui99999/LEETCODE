package List;

import java.util.ArrayList;

public class test725 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        ListNode[] ans = Solution.splitListToParts(l1, 2);
    }
}
class Solution {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = root;
        ListNode[] ans = new ListNode[k];
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int count = list.size();
        int divide = k;
        for (int i = 0; i < k; i++) {
            int sum = (int) Math.ceil((double) count / divide);
            count -= sum;
            divide--;
            if (sum == 0) {
                ans[i] = null;
            } else {
                ListNode nd = new ListNode(root.val);
                ans[i] = nd;
                while (sum-- > 1) {
                    root = root.next;
                    nd.next = new ListNode(root.val);
                    nd = nd.next;
                }
                root = root.next;
            }

        }
        return ans;

    }
}