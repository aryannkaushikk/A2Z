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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = null;
        ListNode t = head;
        ListNode n = null;
        while(t!=null){
            n = t.next;
            t.next = p;
            p = t;
            t = n;
        }
        return p;
    }
}