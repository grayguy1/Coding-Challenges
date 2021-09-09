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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = new ListNode();
        ListNode tempResult = result;
        while(temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                result.next = temp1;
                temp1 = temp1.next;
            }
            else {
                result.next = temp2;
                temp2 = temp2.next;
            }
            result = result.next;
        }
        if (temp1 != null) {
            result.next = temp1;
        }
        else if (temp2 != null) {
            result.next = temp2;
        }
        return tempResult.next;
    }
}