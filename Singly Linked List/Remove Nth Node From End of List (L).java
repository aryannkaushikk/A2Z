Slow-Fast pointer based approach
Move the fast pointer one step at a time for n times
If fast is null then return head.next as it wants to remove 1st element
Else move slow from head and fast simultaneously one step at a time till fast.next!=null i.e. fast reaches last element
Slow will stop at one node before the required node

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
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && n>0){
            fast = fast.next;
            n--;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode next = slow.next.next;
        slow.next.next = null;
        slow.next = next;
        return head;
    }
}
