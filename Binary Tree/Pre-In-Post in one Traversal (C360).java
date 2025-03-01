/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;
public class Solution {

    static class Pair{
        TreeNode n;
        int x;

        public Pair(TreeNode node, int x){
            n = node;
            this.x = x;
        }
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        if(root==null){
            return null;
        }
        Stack<Pair> s = new Stack<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> pre = new LinkedList<>();
        List<Integer> in = new LinkedList<>();
        List<Integer> post = new LinkedList<>();
        s.push(new Pair(root,1));
        while(!s.isEmpty()){
            Pair temp = s.peek();
            TreeNode n = temp.n;
            int x = temp.x;
            if(x==1){
                pre.add(n.data);
                temp.x = x+1;
                if(n.left!=null){
                    s.push(new Pair(n.left,1));
                }
            }
            if(x==2){
                in.add(n.data);
                temp.x = x+1;
                if(n.right!=null){
                    s.push(new Pair(n.right,1));
                }
                
            }
            if(x==3){
                post.add(n.data);
                s.pop();
            }
        }
        res.add(in);
        res.add(pre);
        res.add(post);
        return res;
    }
}
