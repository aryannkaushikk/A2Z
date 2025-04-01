Pretty much same to ceil reverse logic
    
class Solution {
   
    static void floor(Node root, int x, int[] f){
        if(root==null){
            return;
        }
        if(root.data<=x){
            f[0] = Math.max(f[0],root.data);
        }
        if(root.data<x){
            floor(root.right,x,f);
        }else{
            floor(root.left,x,f);
        }
    }
    
    public static int floor(Node root, int x) {
        if(root==null){
            return -1;
        }
        int[] f = {Integer.MIN_VALUE};
        floor(root,x,f);
        if(f[0]==Integer.MIN_VALUE){
            return -1;
        }
        return f[0];
    }
}
