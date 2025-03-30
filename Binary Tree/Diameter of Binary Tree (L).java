Call func for left and right which returns height of left and right
Then compare max,l+r for max diameter
Return max of l,r

Diameter goes through a node whose left height+right height is maximum

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

    public static int getDiameter(TreeNode root, int[] max){
        if(root==null){
            return 0;
        }
        int l = getDiameter(root.left,max);
        int r = getDiameter(root.right,max);

        max[0] = Math.max(max[0],l+r);

        return 1+Math.max(l,r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        getDiameter(root,max);
        return max[0];
    }
}
