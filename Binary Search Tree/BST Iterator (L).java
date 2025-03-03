/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {

    private static Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        pushAll(root);
    }

    public static void pushAll(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        while (temp != null) {
            s.push(temp);
            temp = temp.left;
        }
    }

    public int next() {
        TreeNode temp = s.pop();
        pushAll(temp.right);
        return temp.val;
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
