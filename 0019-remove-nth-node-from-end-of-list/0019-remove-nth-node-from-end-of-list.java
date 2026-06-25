/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode t = head;

        while (t != null) {
            len++;
            t = t.next;
        }

        int pos = len - n;

        // remove head
        if (pos == 0) {
            return head.next;
        }

        t = head;

        for (int i = 1; i < pos; i++) {
            t = t.next;
        }

        t.next = t.next.next;

        return head;
    }
}