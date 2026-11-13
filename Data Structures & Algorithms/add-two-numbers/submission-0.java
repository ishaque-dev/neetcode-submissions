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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          if (l1 == null && l2 == null) {
            return null;
        }
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode answer = dummy;
        while (carry != 0 || l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int total = l1Val + l2Val + carry;
            carry = total / 10;
            ListNode newNode = new ListNode(total % 10);
            answer.next = newNode;
            answer = answer.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return dummy.next;
    }
}
