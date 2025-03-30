Calculate for every node its left sum and right sum
Put max as l+r+root,l+root,r+root,root
and return max of root or root+l+r

Same as diameter we are calculating sum of node values for each node
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

    public static int pathSum(TreeNode root, int[] max){
        if(root==null){
            return 0;
        }
        int l = pathSum(root.left,max);
        int r = pathSum(root.right,max);

        max[0] = Math.max(max[0],l+r+root.val);
        max[0] = Math.max(max[0],l+root.val);
        max[0] = Math.max(max[0],r+root.val);
        max[0] = Math.max(max[0],root.val);

        return Math.max(root.val,root.val+Math.max(l,r));
    }

    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        pathSum(root,max);
        return max[0];
    }
}
