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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode A = l1;
        ListNode B = l2;
        ListNode prev = null;
        int carry = 0;
        while(A!=null && B!=null){
            int sum = A.val+B.val+carry;
            carry = sum/10;
            A.val = sum%10;
            prev = A;
            A = A.next;
            B = B.next;
        }
        while(A!=null){
            int sum = A.val+carry;
            carry = sum/10;
            A.val = sum%10;
            prev = A;
            A = A.next;
        }
        while(B!=null){
            int sum = B.val+carry;
            carry = sum/10;
            ListNode temp = new ListNode(sum%10);
            prev.next = temp;
            prev = prev.next;
            B = B.next;
        }
        if(carry==1){
            prev.next = new ListNode(1);
        }
        return l1;
    }
}
