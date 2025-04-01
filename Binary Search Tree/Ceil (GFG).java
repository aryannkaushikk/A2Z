If root>=key check for min with c then go left to find value smaller then root to check for minimum value >=key else go right

class Tree {
    // Function to return the ceil of given number in BST.
    
    void ceil(Node root, int key, int[] c) {
        if (root == null) return;
        if(root.data>=key){
            c[0] = Math.min(c[0],root.data);
        }
        if(root.data<key){
            ceil(root.right,key,c);
        }else{
            ceil(root.left,key,c);
        }
    }
    
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int[] c = {Integer.MAX_VALUE};
        ceil(root,key,c);
        if(c[0]==Integer.MAX_VALUE){
            return -1;
        }
        return c[0];
    }
}
