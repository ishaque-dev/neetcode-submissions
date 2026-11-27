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
   
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.offer(list.val);
                list = list.next;
            }

        }
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (!priorityQueue.isEmpty()) {
            result.next = new ListNode(priorityQueue.poll());
            result = result.next;
        }

        return dummy.next;

    }
}
