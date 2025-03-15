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

    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        head.next= null;
        front.next = head;
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        ListNode temp = head;
        ListNode l = null;
        ListNode r = null;
        while(temp!=null){
            if(left==2){
                l = temp;
            }
            if(right==1){
                r = temp;
                break;
            }
            left--;
            right--;
            temp = temp.next;
        }
        ListNode prev = null;
        if(l==null){
            l = head;
        }else{
            prev = l;
            l = l.next;
        }        
        ListNode nxt = r.next;
        r.next = null;
        r = reverse(l);
        if(prev==null){
            l.next = nxt;
            return r;    
        }else{
            prev.next = r;
            l.next = nxt;
            return head;
        }
    }
}
