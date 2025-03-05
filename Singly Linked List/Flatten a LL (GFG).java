
class Solution {
    
    public static Node merge(Node a, Node b){
        if(a==null && b==null){
            return null; 
        }else if(a==null){
            return b;
        }else if(b==null){
            return a;
        }else{
            Node c = new Node(-1);
            Node temp = c;
            while(a!=null && b!=null){
                if(a.data>b.data){
                    temp.bottom = b;
                    b = b.bottom;
                }else{
                    temp.bottom = a;
                    a = a.bottom;
                }
                temp = temp.bottom;
            }
            if(a!=null){
                temp.bottom = a;
            }
            if(b!=null){
                temp.bottom = b;
            }
            return c.bottom;
        }
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root==null || root.next==null){
            return root;
        }    
        Node n = flatten(root.next);
        Node newHead = merge(root,n);
        return newHead;
    }
}
