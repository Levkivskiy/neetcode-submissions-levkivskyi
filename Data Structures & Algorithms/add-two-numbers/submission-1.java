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
        ListNode dummy = new ListNode(0);
        ListNode nodeSum = dummy;
        int addPrev = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + addPrev;
            addPrev = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            nodeSum.next = new ListNode(sum);
            nodeSum = nodeSum.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + addPrev;
            addPrev = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            nodeSum.next = new ListNode(sum);
            nodeSum = nodeSum.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + addPrev;
            addPrev = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            nodeSum.next = new ListNode(sum);
            nodeSum = nodeSum.next;
            l2 = l2.next;
        }

        if (addPrev != 0) {
            nodeSum.next = new ListNode(1);
        }

        return dummy.next;
    }
}
