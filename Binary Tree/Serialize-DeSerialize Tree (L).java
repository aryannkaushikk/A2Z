/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp==null){
                s.append("null").append(",");
                continue;
            }
            s.append(temp.val).append(",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1; i<arr.length; i++) {
            TreeNode temp = q.poll();
            if (!arr[i].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(temp.left);
            }
            if(++i==arr.length){
                break;
            }
            if (!arr[i].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(temp.right);
            }
        }
        return root;
    }
}
