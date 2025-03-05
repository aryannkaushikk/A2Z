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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode hA = head;
        ListNode hB = head.next;
        
        ListNode a = hA;
        ListNode b = hB;
        while(b!=null && b.next!=null){
            ListNode temp = b.next.next;
            a.next = b.next;
            b.next = temp;
            a = a.next;
            b = b.next;
        }
        a.next = hB;
        return hA;
    }
}
