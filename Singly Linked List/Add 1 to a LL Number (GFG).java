
/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        if(head==null){
            return null;
        }
        Node curr = head;
        Node prev = null;
        while(curr.next!=null){
            if(curr.data!=9){
                prev = curr;
            }
            curr = curr.next;
        }
        if(curr.data+1<10){
            curr.data = curr.data+1;
            return head;
        }
        else{
            if(prev==null){
                prev = new Node(1);
                prev.next = head;
                head = prev;
                prev = prev.next;
            }
            else{
                prev.data = prev.data+1;
                prev = prev.next;
            }
            while(prev!=curr){
                prev.data = 0;
                prev = prev.next;
            }
            curr.data = 0;
            return head;
        }
    }
}
