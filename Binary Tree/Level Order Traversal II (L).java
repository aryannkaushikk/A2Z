"""
Approach

One way is to simply collect levels from root to leaf then reverse
Other way is to use recursion 
Store each level call recursion using a new List of children of current Level
Then after recurion push list to main List
"""

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

    void rec(List<TreeNode> list, List<List<Integer>> ans){
        if(list.size()==0) return;
        int size = list.size();
        List<Integer> temp = new ArrayList<>();
        List<TreeNode> nextList = new ArrayList<>();
        int i = 0;
        while(i < size){
            TreeNode node = list.get(i++);
            temp.add(node.val);
            if(node.left!=null) nextList.add(node.left);
            if(node.right!=null) nextList.add(node.right);
        }
        rec(nextList, ans);
        ans.add(temp);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        rec(list, ans);
        return ans;
    }
}
