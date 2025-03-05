
/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head==null){
            return null;
        }
        Node ph = null;
        Node p = null;
        Node mh = null;
        Node m = null;
        Node nh = null;
        Node n = null;
        
        while(head!=null){
            if(head.data==0){
                if(p==null){
                    ph = new Node(0);
                    p = ph;
                }else{
                    p.next = new Node(0);
                    p = p.next; 
                    
                }
            }
            else if(head.data==1){
                if(m==null){
                    mh = new Node(1);
                    m = mh;
                }else{
                    m.next = new Node(1);
                    m = m.next;   
                }
            }
            else{
                if(n==null){
                    nh = new Node(2);
                    n = nh;
                }else{
                    n.next = new Node(2);
                    n = n.next;   
                }
            }
            head = head.next;
        }
        if(ph==null){
            if(mh==null){
                return nh;
            }else{
                m.next = nh;
                return mh;
            }
        }else if(mh==null){
            if(ph==null){
                return nh;
            }else{
                p.next = nh;
                return ph;
            }
        }else if(nh==null){
            if(ph==null){
                return mh;
            }else{
                p.next = mh;
                return ph;
            }
        }else{
            p.next = mh;
            m.next = nh;
            return ph;
        }
        
    }
}

