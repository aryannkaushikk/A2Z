Create Mapping in a nested TreeMap as follows : X:[L:{PQ}]
Then iterate for each X and each L in it

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

    public static void preOrder(TreeNode root, int x, int l, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(x)){
            map.put(x,new TreeMap<>());
        }
        if(!map.get(x).containsKey(l)){
            map.get(x).put(l,new PriorityQueue<>());
        }
        map.get(x).get(l).add(root.val);
        preOrder(root.left,x-1,l+1,map);
        preOrder(root.right,x+1,l+1,map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new LinkedList<>();
        preOrder(root,0,0,map);
        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry1: map.entrySet()){
            List<Integer> list = new LinkedList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> entry2: entry1.getValue().entrySet()){
                while(!entry2.getValue().isEmpty()){
                    list.add(entry2.getValue().poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
