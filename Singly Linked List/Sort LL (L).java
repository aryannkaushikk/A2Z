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

    public static ListNode merge(ListNode a, ListNode b){
        ListNode c = new ListNode(-1);
        ListNode p = c;
        while(a!=null && b!=null){
            if(a.val>b.val){
                p.next = b;
                b = b.next;
            }else{
                p.next = a;
                a = a.next;
            }
            p = p.next;
        }
        if(a!=null){
            p.next = a;
        }
        if(b!=null){
            p.next = b;
        }
        return c.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }   
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(right);
        return merge(a,b);
    }
}
