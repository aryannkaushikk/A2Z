"""
Approach

Similar to how we did the Clone LinkedList
Maintaing a HashMap of each Node-newNode
And just a BFS traversal with visited Set
At each Node add newNeighbor to newNode of current Node, if newNeighbor dont exist then create them
"""

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Set<Node> vis = new HashSet<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        vis.add(node);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            Node newN = map.get(n);
            for(Node neigh : n.neighbors){
                Node newNeigh = null;
                if(!map.containsKey(neigh)){
                    newNeigh = new Node(neigh.val);
                    map.put(neigh, newNeigh);
                }else{
                    newNeigh = map.get(neigh);
                }
                newN.neighbors.add(newNeigh);
                if(!vis.contains(neigh)){
                    q.offer(neigh);
                    vis.add(neigh);
                }
            }
        }
        return newNode;
    }
}
