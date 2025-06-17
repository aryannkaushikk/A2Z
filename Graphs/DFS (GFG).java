"""
Approach

Recursive Stack
"""

class Solution {
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int v, int[] vis, ArrayList<Integer> list){
        if(vis[v]==1) return;
        vis[v]=1;
        list.add(v);
        for(int x: adj.get(v)){
            dfs(adj, x, vis, list);
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(adj, 0, new int[adj.size()], list);
        return list;
    }
}
