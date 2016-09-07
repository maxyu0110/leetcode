/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        int carry = helper(head);
        if(carry == 0) return head;
        ListNode res = new ListNode(carry);
        res.next = head;
        return res;
    }
    
    private int helper(ListNode head) {
        if(head == null) {
            return 1;
        }
        int carry = helper(head.next);
        head.val += carry;
        carry = head.val / 10;
        head.val %= 10;
        return carry;
    }
}