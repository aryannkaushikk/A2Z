Level Order Traversal
Maintaining a number for each child node based on parents index
Every level starts again with indexing
You take min index from first element of queue in that level
and keep subtracting and finding max width till end

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

    private static class Pair{
        TreeNode node;
        int idx;

        public Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans = 0;
        while (!q.isEmpty()){
            int min = q.peek().idx;
            int size = q.size();
            int first = 0;
            int last = 0;
            for (int i = 0; i<size; i++){
                TreeNode temp = q.peek().node;
                int curr_idx = q.peek().idx;
                q.poll();
                if(i==0) first = curr_idx;
                if(i==size-1) last = curr_idx;
                if(temp.left!=null){
                    q.offer(new Pair(temp.left, 2*curr_idx+1));
                }
                if(temp.right!=null){
                    q.offer(new Pair(temp.right, 2*curr_idx+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}
