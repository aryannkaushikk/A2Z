Level order traversal and keep re-writing map for every x

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    
    static class Pair{
        Node node;
        int x;
        
        public Pair(Node node, int x){
            this.node = node;
            this.x = x;
        }
    }
    
    public static void levelOrder(Node root, TreeMap<Integer, Integer> map){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node node = p.node;
            int x = p.x;
            map.put(x,node.data);
            if(node.left!=null){
                q.offer(new Pair(node.left,x-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,x+1));
            }
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
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
