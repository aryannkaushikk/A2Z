"""
Approach

Maintain a pathVis array along with Vis array
You keep marking to pathVis as you move forward on a path
and mark 0 when you backtrack
If you find a neighbour who is visited on pathVis
Then there is a cycle
"""

class Solution {
    
    boolean dfs(int V, List<List<Integer>> adj, int[] vis, int[] pathVis){
        pathVis[V] = 1;
        vis[V] = 1;
        
        for(int neighbour: adj.get(V)){
            if(pathVis[neighbour]==0 && dfs(neighbour, adj, vis, pathVis)) return true; 
            if(pathVis[neighbour]==1) return true;
        }
        
        pathVis[V] = 0;
        
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        for(int i = 0; i<V; i++){
            if(vis[i]==0 && dfs(i, adj, vis, pathVis)) return true;
        }
        
        return false;
    }
}
