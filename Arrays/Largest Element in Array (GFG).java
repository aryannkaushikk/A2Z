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

    public static ListNode reverse(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        if(head2==null){
            return;
        }
        slow.next = null;
        if(head2.next!=null){
            head2 = reverse(head2);
        }
        ListNode t1 = head;
        ListNode t2 = head2;
        while(t1!=null && t2!=null){
            ListNode n1 = t1.next;
            ListNode n2 = t2.next;
            t1.next = t2;
            t1 = n1;
            t2.next = t1;
            t2 = n2;
        }
    }
}