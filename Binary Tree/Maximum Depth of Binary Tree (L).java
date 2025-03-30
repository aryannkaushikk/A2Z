Each root calls the func for its left and right
And then returns max of (l,r) + 1 
Recursively reach the leaf node they return height 1 and then its parent get height of its l and r. Whichever is higher in value plus 1 is then new height this node returns.
This goes on till root
    
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

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1+Math.max(l,r);
    }
}
