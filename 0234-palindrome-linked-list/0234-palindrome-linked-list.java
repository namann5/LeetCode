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
    public boolean isPalindrome(ListNode head) {
        List <Integer> res = new ArrayList<>();

        while(head != null){
            res.add(head.val);
            head = head.next;
        }
        int i=0,
            j= res.size()-1;

            while(i<j){
                if(res.get(i) != res.get(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
    }
}