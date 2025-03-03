/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static class BSTIterator {

        private static Stack<TreeNode> s;

        public BSTIterator(TreeNode root){
            s = new Stack<>();
            pushAll(root);
        }

        public static void pushAll(TreeNode root){
            if(root==null){
                return;
            }
            TreeNode temp = root;
            while(temp!=null){
                s.push(temp);
                temp = temp.left;
            }
        }

        public int next(){
            TreeNode temp = s.pop();
            pushAll(temp.right);
            return temp.val;
        }

        public boolean hasNext(){
            return !s.isEmpty();
        }
    }

    static class BSTIterator2 {

        private static Stack<TreeNode> s;

        public BSTIterator2(TreeNode root){
            s = new Stack<>();
            pushAll(root);
        }

        public static void pushAll(TreeNode root){
            if(root==null){
                return;
            }
            TreeNode temp = root;
            while(temp!=null){
                s.push(temp);
                temp = temp.right;
            }
        }

        public int before(){
            TreeNode temp = s.pop();
            pushAll(temp.left);
            return temp.val;
        }

        public boolean hasBefore(){
            return !s.isEmpty();
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        BSTIterator b1 = new BSTIterator(root);
        BSTIterator2 b2 = new BSTIterator2(root);
        int a = b1.next();
        int b = b2.before();
        while (a<b){
            if(a+b==k){
                return true;
            }else if(a+b<k){
                a = b1.next();
            }else{
                b = b2.before();
            }
        }
        return false;
    }
}
