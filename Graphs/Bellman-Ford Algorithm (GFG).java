"""
Approach

Single Source Shortest Path

Works on negative edge weights and DG
If given a UG then convert to DG

Relax each edge V-1 times
and if there is relaxation after that there is a negative cycle

V-1 times because it can take max V-1 times to reach from a node to other 
"""
  
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[src] = 0;
        for(int j = 0; j<V-1; j++){
            for(int i = 0; i<edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];
                
                if(dist[u]!=100000000 && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            if(dist[u]!=100000000 && dist[u] + w < dist[v]){
                return new int[] {-1};
            }
        }
        
        return dist;
    }
}

  
