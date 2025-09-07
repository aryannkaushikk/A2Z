"""
Approach

Find Max 
Make Root
Left recursion
Right recursion
"""

class Solution {

    TreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        int max = -1;
        int id = -1;
        for(int i = start; i<=end; i++){
            if(nums[i]>max){
                max = nums[i];
                id = i;
            } 
        }
        TreeNode root = new TreeNode(nums[id]);
        root.left = buildTree(nums, start, id-1);
        root.right = buildTree(nums, id+1, end);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
}
