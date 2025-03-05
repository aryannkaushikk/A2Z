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

    public static void reverse(ListNode t, ListNode[] p, ListNode n){
        if(t==null){
            return;
        }
        n = t.next;
        t.next = p[0];
        p[0] = t;
        t = n;
        reverse(t,p,n);
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode[] p = {null};
        ListNode n = null;
        reverse(slow.next,p,n);
        ListNode temp = head;
        ListNode temp2 = p[0];
        while(temp!=null && temp2!=null){
            if(temp.val!=temp2.val){
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }
}
