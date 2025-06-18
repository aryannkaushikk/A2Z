"""
Approach

Same track parent and if you come across a visited node mark cycle true
"""

class Solution {
    
    public boolean dfs(List<List<Integer>> adj, int V, int parent, int[] vis){
        vis[V] = 1;
    
        for (int i : adj.get(V)) {
            if (vis[i] == 0) {
                if (dfs(adj, i, V, vis)) return true;
            } else if (i != parent) {
                return true;
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
            if(vis[i]!=1 && dfs(adj,i,-1,vis)) return true;
        }
        return false;
    }
}
