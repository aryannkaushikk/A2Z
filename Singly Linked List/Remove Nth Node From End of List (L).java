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
        ListNode prev = null;
        ListNode curr = head;
        int l = 1;
        while(curr.next!=null){
            l++;
            prev = curr;
            curr = curr.next;
        }
        int i = l-n+1;
        if(i==1){
            return head.next;
        }
        if(i==l){
            prev.next = null;
            return head;
        }
        prev = null;
        curr = head;
        for(int a = 1; a<i; a++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
