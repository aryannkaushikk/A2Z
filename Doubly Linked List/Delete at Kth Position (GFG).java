Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if(head==null){
            return null;
        }
        if(x==1){
            Node front = head.next;
            if(front!=null){
                front.prev = null;
                head.next = null;
                return front;
            }
            return null;
        }
        Node temp = head;
        int c = 0;
        while(temp.next!=null){
            c++;
            if(c==x){
                break;
            }
            temp = temp.next;
        }
        Node back = temp.prev;
        Node front = temp.next;
        if(front==null){
            back.next = null;
            temp.prev = null;
            return head;
        }
        back.next = front;
        front.prev = back;
        temp.next = null;
        temp.prev = null;
        return head;
        
    }
}
