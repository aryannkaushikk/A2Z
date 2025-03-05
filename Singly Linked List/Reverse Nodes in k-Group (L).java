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
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode findK(ListNode head, int k){
        if(head==null){
            return null;
        }
        int i = 1;
        ListNode temp = head;
        while(i<k){
            temp = temp.next;
            if(temp==null){
                return null;
            }
            i++;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode temp = head;
        ListNode newHead = null;
        ListNode prev = null;
        while(temp!=null){
            ListNode kNode = findK(temp,k);
            if(kNode==null){
                prev.next = temp;
                break;
            }
            ListNode nxt = kNode.next;
            kNode.next = null;
            ListNode nh = reverse(temp);
            if(temp==head){
                newHead = nh;
            }else{
                prev.next = nh;
            }
            prev = temp;
            temp = nxt;
        }
        return newHead;
    }
}
