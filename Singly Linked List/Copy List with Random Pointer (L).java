/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node t1 = head;
        Node newHead = new Node(head.val);
        Node t2 = newHead;
        int i = 0;
        while(t1!=null){
            map.put(t1,t2);
            t1 = t1.next;
            if(t1==null){
                break;
            }
            Node x = new Node(t1.val);
            t2.next = x;
            t2 = t2.next;
        }
        t1 = head;
        t2 = newHead;
        while(t1!=null){
            Node anxt = t1.random;
            if(anxt!=null){
                t2.random = map.get(anxt);
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return newHead;
    }
}
