class Solution {
    
    static int f;
    
    public static void fl(Node root, int x){
        if(root==null){
            return;
        }
        if(root.data<=x){
            f = root.data;
            fl(root.right,x);
        }else{
            fl(root.left,x);
        }
    }
    
    public static int floor(Node root, int x) {
        if(root==null){
            return -1;
        }
        f = -1;
        fl(root,x);
        return f;
    }
}
