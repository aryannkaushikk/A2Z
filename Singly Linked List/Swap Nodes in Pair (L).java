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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode prev = null;
        int i = 0;
        while(a!=null && b!=null){
            if(prev!=null){
                prev.next = b;    
            }
            a.next = b.next;
            b.next = a;
            if(i==0){
                head = b;
                i++;
            }
            prev = a;
            a = a.next;
            if(a==null){
                break;
            }
            b = a.next;
        }
        return head;
    }
}
