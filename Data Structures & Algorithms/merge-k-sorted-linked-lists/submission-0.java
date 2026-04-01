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
       public ListNode splitLists(ListNode[] lists, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            ListNode left = splitLists(lists, l, m);
            ListNode right = splitLists(lists, m + 1, r);
            return mergeSortedLists(left, right);
        }
        return lists[l];
    }

    public ListNode mergeSortedLists(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                curr.next = l;
                curr = l;
                l = l.next;
            } else {
                curr.next = r;
                curr = r;
                r = r.next;
            }
        }

        if (l != null) {
            curr.next = l;
        }
        if (r != null) {
            curr.next = r;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return splitLists(lists, 0, lists.length - 1);
    }
}
