/* Linked List Node
struct Node {
    int data;
    struct Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}; */

class Solution {
    Node removeDuplicates(Node head) {
        if(head==null){
            return null;
        }
        int x = head.data;
        Node temp = head.next;
        Node prev = head;
        while(temp!=null){
            if(temp.data==x){
                prev.next = temp.next;
                temp.next = null;
                temp = prev.next;
                continue;
            }else{
                
                x = temp.data;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
