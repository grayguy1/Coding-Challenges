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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode temp = prev;
        while(head != null) {
            if (head.val == val) {
                temp.next = head.next;
            }
            else {
                temp = head;
            }
            head = head.next;
        }
        return prev.next;
    }
}