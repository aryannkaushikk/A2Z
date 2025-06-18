"""
Approach

Firstly we have to maintain who was the parent node of current node i.e. which node pushed current in Queue.
While going through adjacent node list we skip parent and if we find a node thats visited then there is a cycle.
"""

class Solution {
    
    public boolean bfs(List<List<Integer>> adj, int V, int[] vis){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {V, -1});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            
            vis[node] = 1;
            
            for(int i : adj.get(node)){
                if(i==parent) continue;
                if(vis[i]!=1){
                    q.offer(new int[] {i, node});
                }
                else{
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis = new int[adj.size()];
        for(int i = 0; i<V; i++){
            if(vis[i]!=1 && bfs(adj,i,vis)) return true;
        }
        return false;
    }
}
