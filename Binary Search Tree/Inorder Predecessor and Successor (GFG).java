class Solution {
    
    public static Node ceil(Node root, int key, Node curr){
        if(root==null){
            return curr;
        }
        if(root.data>key){
            if(curr.data>ceil(root.left,key,root).data){
                curr = ceil(root.left,key,root);
            }
            return curr;
        }
        else{
            return ceil(root.right,key,curr);
        }
    }
    
    
    public static Node floor(Node root, int key, Node curr){
        if(root==null){
            return curr;
        }
        if(root.data<key){
            if(curr.data<floor(root.right,key,root).data){
                curr = floor(root.right,key,root);
            }
            return curr;
        }
        else{
            return floor(root.left,key,curr);
        }
    }
    
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        if(root==null){
            return;
        }
        pre[0] = null;
        suc[0] = null;
        Node p = floor(root,key,new Node(Integer.MIN_VALUE));
        Node s = ceil(root,key,new Node(Integer.MAX_VALUE));
        if(p.data>Integer.MIN_VALUE){
            pre[0] = p;
        }
        if(s.data<Integer.MAX_VALUE){
            suc[0] = s;
        }
    }
}
