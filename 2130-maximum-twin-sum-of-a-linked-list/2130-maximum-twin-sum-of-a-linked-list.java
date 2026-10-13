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
    public int pairSum(ListNode head) {
         //fast and slow se middle
         //reverse on slow
         //sum calc

         ListNode slow =head,
                  fast = head;

                  while(fast != null && fast.next != null){
                    slow = slow.next;
                    fast = fast.next.next;
                  }

                  ListNode p2= reverseLL(slow);
                  ListNode p1 = head;

                    int max = Integer.MIN_VALUE;
                  while(p1 != null && p2 != null){
                    int c = p1.val + p2.val;
                    max = Math.max(max,c);
                    p1 = p1.next;
                    p2 = p2.next;
                  }
                  return max;
    }
    public ListNode reverseLL(ListNode head){
       ListNode prev = null;
       ListNode cur = head;

       while(cur != null){
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
       }
       return prev;
    }
}