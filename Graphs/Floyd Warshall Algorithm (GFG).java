"""

Multi Source Shortes Path

Brute Approach is use Bellman for V times (making each node as src 1 at a time)

But rather optimised is Floyd-Warshall

Each time from 0 to V-1 you compute if you can go U to V via a node VIA

To detect cycle in this
If diagnols have value below 0 then there is cycle
"""

class Solution {
    public void floydWarshall(int[][] dist) {
        int V = dist.length;
        int MAX = 100000000;
        for(int via = 0; via<V; via++){
            for(int i = 0; i<V; i++){
                for(int j = 0; j<V; j++){
                    if(dist[i][via]!=MAX && dist[via][j]!=MAX) dist[i][j] = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                }
            }
        }
    }
}
