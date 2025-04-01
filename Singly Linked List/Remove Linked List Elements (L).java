Keep moving head till head element is val
Then maintain temp and prev
Whenever temp is val remove it using prev

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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        while(head!=null && head.val==val){
            head = head.next;
        }
        if(head==null){
            return null;
        }
        ListNode prev = head;
        ListNode temp = head.next;
        while(temp!=null){
            if(temp.val==val){
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
                prev.next = temp;
            }else{
                prev = temp;
                temp = temp.next;    
            }
        }
        return head;
    }
}
