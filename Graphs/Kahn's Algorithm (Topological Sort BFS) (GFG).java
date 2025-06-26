"""
Approach

Kahn's Algorithm is used to perform topological sort using BFS

Key Point: Every DAG will have atleast 1 Node with in-degree 0

Now, Start with a queue in which you push the Node(s) with in-degree 0
Traverse the neighbours and decrease their in-degree in the in-degree array (we dont need vis array here in-degree works)
Whenever after reduction in-degree becomes 0 add that node to queue
And after traversing all neighbour of a node add it to list

End list is your sorted list
"""

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<V; i++){
            if(indegree[i]==0){
                q.offer(i);
            } 
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0) q.offer(n);
            }
            list.add(node);
        }
        
        return list;
    }
}
