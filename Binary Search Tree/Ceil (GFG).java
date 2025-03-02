class Tree {
    static int c;
    public static void ceil(Node root, int key){
        if(root==null){
            return;
        }
        if(root.data>=key){
            c = root.data;
            ceil(root.left,key);
        }
        else{
            ceil(root.right,key);
        }
    }
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        c = -1;
        ceil(root,key);
        return c;
    }
}
