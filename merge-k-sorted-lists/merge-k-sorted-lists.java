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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode merged = new ListNode(-1);
        ListNode temp = merged;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            ListNode curr = new ListNode(val);
            temp.next = curr;
            temp = temp.next;
        }
        return merged.next;
    }
}