// Node is defined as:
// class Node{
//     int val;
//     Node next;
//     Node(int x){
//     	val = x; next = null;
//     }
// }
class Solution{
    static int solve(Node root){
        if(root==null || root.next==null){
            return 0;
        }
        Node prev = root;
        Node curr = root.next;
        Node next = root.next.next;
        int c=0;
        while(next!=null){
            if((prev.val>curr.val && next.val>curr.val) || (prev.val<curr.val && next.val<curr.val)){
                c++;
            }   
            prev = curr;
            curr = next;
            next = next.next;
        }
        return c;
    }
}
