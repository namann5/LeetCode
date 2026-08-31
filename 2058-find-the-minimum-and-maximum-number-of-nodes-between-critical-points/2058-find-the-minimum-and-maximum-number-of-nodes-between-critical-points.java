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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        int pos = 1;

        while (curr.next != null) {

            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                list.add(pos);
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        int max = list.get(list.size() - 1) - list.get(0);

        return new int[]{min, max};
    }
}