"""
Approach

If there are n components then n-1 edges are required minimum to connect them
But in each component we need to count for extra edges, removing and reusing those will not break the component
If extra edges >= comp - 1 then we can connect else no
"""

class Solution {

    int findPar(int[] par, int x){
        if(par[x]==x) return x;
        return par[x] = findPar(par, par[x]);
    }

    int union(int[] par, int a, int b){
        int pa = findPar(par, a);
        int pb = findPar(par, b);
        if(pa==pb) return 1;
        else{
            par[pa] = pb;
            return 0;
        }
    }


    public int makeConnected(int n, int[][] connections) {
        int count = 0;
        int[] par = new int[n];
        for(int i = 0; i<n; i++) par[i] = i;
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            count += union(par, u, v);
        }
        int comp = 0;
        for(int i = 0; i<n; i++) if(par[i]==i) comp++;
        if(count>=comp-1) return comp-1;
        return -1;
    }
}
