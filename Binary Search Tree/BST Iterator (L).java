When the BSTIterator is instantiated pushAll all values of left from root
When next is called pop from stack and pushAll for curr.right and return curr.val
hasNext is answered by checking stack is empty or not

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
class BSTIterator {

    static Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
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

    public int next() {
        TreeNode curr = s.pop();
        pushAll(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
