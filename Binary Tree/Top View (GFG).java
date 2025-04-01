Iterate in Level Order and keep storing in TreeMap in x:value pair if x does not exist

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
    
    static class Pair{
        Node root;
        int x;
        
        public Pair(Node root, int x){
            this.root = root;
            this.x = x;
        }
    }
    
    public static void levelOrder(Node root, TreeMap<Integer, Integer> map){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node n = p.root;
            int x = p.x;
            if(!map.containsKey(x)){
                map.put(x,n.data);
            }
            if(n.left!=null){
                q.offer(new Pair(n.left,x-1));
            }
            if(n.right!=null){
                q.offer(new Pair(n.right,x+1));
            }
        }
    }
    
    static ArrayList<Integer> topView(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        levelOrder(root,map);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}
