"""
Approach

Using Kruskal Algorithm via Disjoint Set Union-Find Approach

Sort the edges
If the current edge's nodes' parents are not equal union and add weight
"""

class Solution {
    
    int findPar(int[] par, int x){
        if(par[x]==x) return x;
        return par[x] = findPar(par, par[x]);
    }
    
    boolean union(int[] par, int a, int b){
        int pa = findPar(par, a);
        int pb = findPar(par, b);
        
        if(pa==pb) return false;
        else{
            par[pa] = pb;
            return true;
        }
    }
    
    public int spanningTree(int V, int[][] edges) {
        int[] par = new int[V];
        for(int i = 0; i<V; i++) par[i] = i;
        int sum = 0;
        
        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(union(par, u, v)) sum += w;
        }
        return sum;
    }
}
