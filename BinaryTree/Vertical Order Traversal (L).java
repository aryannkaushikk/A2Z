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

    private static class Tuple{
        TreeNode n;
        int x;
        int l;

        public Tuple(TreeNode n, int x, int l){
            this.n = n;
            this.l = l;
            this.x = x;
        }
    }

    private static TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mapping(TreeNode root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while (!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode n = temp.n;
            int x = temp.x;
            int l = temp.l;
            if(n.left!=null){
                q.offer(new Tuple(n.left,x-1,l+1));
            }
            if(n.right!=null){
                q.offer(new Tuple(n.right,x+1,l+1));
            }
            if(!map.containsKey(x)){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(n.val);
                TreeMap<Integer, PriorityQueue<Integer>> tmap = new TreeMap<>();
                tmap.put(l,pq);
                map.put(x,tmap);
            }
            else{
                if(!map.get(x).containsKey(l)){
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(n.val);
                    map.get(x).put(l,pq);
                }
                else{
                    map.get(x).get(l).add(n.val);
                }
            }
        }
        return map;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = mapping(root);
        List<List<Integer>> list = new LinkedList<>();
        for (Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry: map.entrySet()){
            List<Integer> temp = new LinkedList<>();
            for (Map.Entry<Integer,PriorityQueue<Integer>> entry2 : entry.getValue().entrySet()){
                PriorityQueue<Integer> pqt = entry2.getValue();
                if(pqt.size()==1){
                    temp.add(pqt.poll());
                    continue;
                }
                while (!pqt.isEmpty()){
                    temp.add(pqt.poll());
                }
            }
            list.add(temp);
        }
        return list;
    }
}
