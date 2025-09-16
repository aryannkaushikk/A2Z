class Solution {

    int sumInRight(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;

        int left = sumInLeft(root.left);
        int right = sumInRight(root.right);

        return left+right;
    }

    int sumInLeft(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;

        int left = sumInLeft(root.left);
        int right = sumInRight(root.right);

        return left+right;
    }


    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;

        int left = sumInLeft(root.left);
        int right = sumInRight(root.right);

        return left+right;
    }
}
