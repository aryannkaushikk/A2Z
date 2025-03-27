/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    
    static class TreeNode {
        int x;
        int l;
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(int x, int l,int data){
            this.x = x;
            this.l = l;
            this.data = data;
        }
    }
    
    static ArrayList<Integer> list;

    public static void print(TreeNode root){
        if (root==null) {
            return;
        }
        print(root.left);
        list.add(root.data);
        print(root.right);
    }

    public static TreeNode insertBST(int x, int l,int data, TreeNode root){
        if (root==null) {
            return new TreeNode(x, l, data);
        }else if(root.x==x){
            if(root.l>l){
                root.x = x;
                root.l = l;
                root.data = data;
            }
            return root;
        }else if(root.x>x){
            root.left = insertBST(x, l,data, root.left);
        }else{
            root.right = insertBST(x, l,data, root.right);
        }
        return root;
    }

    static TreeNode map;

    public static void inOrder(Node root, int x, int l){
        if(root==null){
            return;
        }
        map = insertBST(x,l,root.data,map);
        inOrder(root.left, x-1,l+1);
        inOrder(root.right, x+1,l+1);
    }
    
    static ArrayList<Integer> topView(Node root) {
        list = new ArrayList<>();
        map = null;
        inOrder(root,0,0);
        print(map);
        return list;
    }
}
