"""
Approach

Return -1 if current node value is out of range else 0
If a node's left or right return -1 replace with their left or right whichever not null or with null if both null
"""

class Solution {

    int trim(TreeNode root, int low, int high){
        if(root==null) return 0;

        int left = trim(root.left, low, high);
        int right = trim(root.right, low, high);

        if(left==-1) root.left = root.left.left!=null ? root.left.left : root.left.right;
        if(right==-1) root.right = root.right.left!=null ? root.right.left : root.right.right;

        if(root.val<low || root.val>high) return -1;
        return 0;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        int x = trim(root, low, high);
        if(x==-1){
            return root.left==null ? root.right : root.left;
        }
        return root;
    }
}
