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

    public static void reverseList(ListNode t, ListNode[] p, ListNode n){
        if(t==null){
            return;
        }
        n = t.next;
        t.next = p[0];
        p[0] = t;
        t = n;
        reverseList(t,p,n);
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode[] p = {null};
        ListNode t = head;
        ListNode n = null;
        reverseList(t,p,n);
        return p[0];
    }
}