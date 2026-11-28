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
     private ListNode reverseNodes(ListNode head, int count) {

        ListNode newHead = null;
        ListNode current = head;

        while (count > 0) {
            ListNode temp = current.next;
            current.next = newHead;
            newHead = current;
            current = temp;
            count--;
        }
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
            ListNode newHead = null;
        ListNode tail = null;
        ListNode ptr = head;
        while (ptr != null) {
            int count = 0;

            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }
            if (count == k) {
                ListNode revHead = reverseNodes(head, k);

                if (newHead == null) {
                    newHead = revHead;
                }
                if (tail != null) {
                    tail.next = revHead;
                }

                tail = head;
                head = ptr;
            }

        }
        if (tail != null) {
            tail.next = head;
        }
        return newHead == null ? head : newHead;
    }
}
