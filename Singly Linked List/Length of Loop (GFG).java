/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        if(head==null){
            return 0;
        }
        Node slow = head;
        Node fast = head;
        boolean flag = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                flag = true;
                break;
            }
        }
        if(flag){
            int count = 0;
            do{
                slow = slow.next;
                count++;
            }while(slow!=fast);
            return count;
        }
        return 0;
    }
}