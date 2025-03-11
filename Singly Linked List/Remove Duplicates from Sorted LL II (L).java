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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                while(curr.next!=null && curr.val==curr.next.val){
                    curr = curr.next;
                }
                if(prev==null){
                    curr = curr.next;
                    head = curr;
                }else{
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
