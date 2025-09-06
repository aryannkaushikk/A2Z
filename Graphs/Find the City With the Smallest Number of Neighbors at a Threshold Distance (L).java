"""
Approach

Use Floyd Warshall to find Shortest Path to each city from each city
Then for each city as source check how many cities are within Threshold Distance
Then return the one with largest number and minium cities
"""

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long[][] adj = new long[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i] = 0;
        } 
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj[u][v] = w;
            adj[v][u] = w;
        }

        for(int via = 0; via<n; via++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(adj[i][j] > adj[i][via]+adj[via][j]){
                        adj[i][j] = adj[i][via]+adj[via][j];
                    }
                }
            }
        }
        int city = -1;
        int minCount = n+1;
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(adj[i][j]<=distanceThreshold) count++;
            }
            if(count<minCount){
                minCount = count;
                city = i;
            }else if(count==minCount){
                city = i;
            }
        }
        return city;
    }
}
