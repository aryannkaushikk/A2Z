/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    private static class Tuple{
        Node n;
        int x;
        int l;

        public Tuple(Node n, int x, int l){
            this.n = n;
            this.l = l;
            this.x = x;
        }
    }

    private static TreeMap<Integer,TreeMap<Integer,Integer>> mapping(Node root){
        TreeMap<Integer,TreeMap<Integer, Integer>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while (!q.isEmpty()){
            Tuple temp = q.poll();
            Node n = temp.n;
            int x = temp.x;
            int l = temp.l;
            if(n.left!=null){
                q.offer(new Tuple(n.left,x-1,l+1));
            }
            if(n.right!=null){
                q.offer(new Tuple(n.right,x+1,l+1));
            }
            if(!map.containsKey(x)){
                TreeMap<Integer, Integer> tmap = new TreeMap<>();
                tmap.put(l,n.data);
                map.put(x,tmap);
            }
        }
        return map;
    }
    
    
    static ArrayList<Integer> topView(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        TreeMap<Integer,TreeMap<Integer, Integer>> map = mapping(root);
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, TreeMap<Integer, Integer>> entry: map.entrySet()){
            for(Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()){
                list.add(entry2.getValue());
            }
        }
        return list;
    }
}
