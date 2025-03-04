/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        if(p==0){
            return new Node(x);
        }
        int c = 0;
        Node temp = head;
        while(temp.next!=null){
            if(c==p){
                break;
            }
            temp = temp.next;
            c++;
        }
        Node front = temp.next;
        Node t = new Node(x);
        if(front==null){
            temp.next = t;
            t.prev = temp;
            return head;
        }
        temp.next = t;
        front.prev = t;
        t.next = front;
        t.prev = temp;
        return head;
    }
}
