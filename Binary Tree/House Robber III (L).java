"""
Approach

DP on trees

At each point return a n=2 array
where arr[0] is the amount when you dont rob this root and arr[1] is when you do rob this

for current root

arr[0] = MAX(left[0],left[1]) + MAX(right[0]+right[1]) meaning you may or may not rob the children
arr[1] = root.val + left[0] + right[0] meaning you cant rob the children
"""

class Solution {

    int[] robber(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left = robber(root.left);
        int[] right = robber(root.right);

        int robThis = root.val + left[0] + right[0];
        int notRobThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notRobThis, robThis};
    }

    public int rob(TreeNode root) {
        int[] res = robber(root);
        return Math.max(res[0], res[1]);
    }
}
