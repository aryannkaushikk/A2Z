"""
Approach

Simple DFS
But when you backtrack add the node to a stack (this node's dfs is done)
From top to bottom is the sorted order
"""

class Solution {
    
    static void dfs(List<List<Integer>> adj, int V, int[] vis, Stack<Integer> s){
        if(vis[V]==1) return;
        
        vis[V]=1;
        
        for(int neighbor : adj.get(V) ){
            if(vis[neighbor]==0) dfs(adj, neighbor, vis, s);
        }
        
        s.push(V);
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V];
        for(int i = 0; i<V; i++){
            if(vis[i]==0) dfs(adj, i, vis, s);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty()){
            list.add(s.pop());
        }
        return list;
    }
}
