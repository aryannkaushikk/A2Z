"""
Approach

If Current is not less than prev go ahead
Else If current is less than head insert at head
Else Find Node greater than current maintain previous
Disconnect node and insert between tempPrev and tempCurr
"""
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;

            } else if (curr.val <= head.val) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;

            } else {
                int x = curr.val;
                ListNode tempPrev = null;
                ListNode tempCurr = head;
                while (tempCurr.val <= curr.val) {
                    if (tempCurr.val > x) {
                        break;
                    }
                    tempPrev = tempCurr;
                    tempCurr = tempCurr.next;
                }
                if (tempCurr != curr) {
                    prev.next = curr.next;
                    curr.next = null;
                    if (tempPrev == null) {
                        head = curr;
                    } else {
                        tempPrev.next = curr;
                    }
                    curr.next = tempCurr;
                    curr = prev;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
