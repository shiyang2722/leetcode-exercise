package examination;

import util.ListNode;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/12.
 */
public class Q25_20191112 {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode end = dummy;
            while (end != null) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) break;
                ListNode next = end.next;
                ListNode start = pre.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;
                end = pre;
            }

            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        ListNode node = solution.reverseKGroup(node1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
