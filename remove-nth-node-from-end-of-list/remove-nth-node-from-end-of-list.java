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
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode curr = temp;
        ListNode pred = temp;
        while (n >= 0) {
            curr = curr.next;
            n--;
        }
        while (curr != null) {
            curr = curr.next;
            pred = pred.next;
        }
        pred.next = pred.next.next;
        return temp.next;
    }
}