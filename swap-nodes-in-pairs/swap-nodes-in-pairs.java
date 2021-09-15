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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode prev = temp;
        while (head != null && head.next != null) {
            ListNode curr = head;
            ListNode next = head.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            head = curr.next;
        }
        return temp.next;
    }
}