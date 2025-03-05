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
    static Node deleteAllOccurOfX(Node head, int x) {
        if(head==null){
            return null;
        }
        Node temp = head;
        while(temp!=null){
            Node back = temp.prev;
            Node front = temp.next;
            if(temp.data==x){
                if(back==null && front==null){
                    return null;
                }
                else if(back==null){
                    temp.next = null;
                    front.prev = null;
                    head = front;
                }
                else if(front==null){
                    back.next = null;
                    temp.prev = null;
                    break;
                }else{
                    back.next = front;
                    front.prev = back;
                    temp.next = null;
                    temp.prev = null;
                }
            }
            temp = front;
        }
        return head;
    }
}
