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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int l = 1;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
            l++;
        }
        if(k%l==0){
            return head;
        }
        tail.next = head;
        int n = l-(k%l);
        if(n==0){
            return head;
        }
        ListNode temp = head;
        while(n>1){
            temp = temp.next;
            n--;
        }
        ListNode nh = temp.next;
        temp.next = null;
        return nh;
    }
}
