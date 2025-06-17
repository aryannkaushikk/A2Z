"""
This problem counts number of connected components

The idea is to call dfs OR bfs on each vertex if they have not been visited and count++
This will only trigger the number of times there are components as one call will visit all nodes of that component
"""

class Solution {

    public void dfs(int[][] mat, int v, int[] vis){
        if(vis[v]==1) return;

        vis[v] = 1;
        for(int i = 0; i<mat[v].length; i++){
            if(mat[v][i]==1 && vis[i]!=1) dfs(mat, i, vis);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        int[] vis = new int[size];
        int count = 0;
        for(int i = 0; i<size; i++){
            if(vis[i]==0){
                dfs(isConnected, i, vis);
                count++;
            } 
        }
        return count;
    }
}
