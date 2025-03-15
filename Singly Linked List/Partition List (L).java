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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode headA = null;
        ListNode tailA = null;
        ListNode headB = null;
        ListNode tailB = null;
        ListNode sub = null;
        while(temp!=null){
            sub = temp.next;
            temp.next = null;
            if(temp.val<x){
                if(headA==null){
                    headA = temp;
                    tailA = temp;
                }else{
                    tailA.next = temp;
                    tailA = tailA.next;
                }
            }
            else{
                if(headB==null){
                    headB = temp;
                    tailB = temp;
                }else{
                    tailB.next = temp;
                    tailB = tailB.next;
                }
            }
            temp = sub;
        }
        if(headA==null){
            return headB;
        }
        tailA.next = headB;
        return headA;
    }
}
