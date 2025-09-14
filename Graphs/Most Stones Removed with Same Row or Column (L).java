"""
Approach

Union The row and col of each cell where stone is
Store each nodeRow and Nodecol in a set 
Later iterate set and check for each x which is parent of self count++ as in number of components
Finally return stones-components
"""

class Solution {

    int findPar(int[] par, int x){
        if(par[x]==x) return x;
        return par[x] = findPar(par, par[x]);
    }

    void union(int[] par, int[] size, int a, int b){
        int pa = findPar(par, a);
        int pb = findPar(par, b);
        if(pa==pb) return;
        else if(size[pa] > size[pb]){
            par[pb] = pa;
            size[pa] += size[pb];
        }else{
            par[pa] = pb;
            size[pb] += size[pa];
        }
    }

    public int removeStones(int[][] stones) {
        int len = stones.length;

        int n = 0;
        int m = 0;

        for(int i = 0; i<len; i++){
            n = Math.max(n, stones[i][0]);
            m = Math.max(m, stones[i][1]);
        }

        int[] par = new int[n+m+2];
        int[] size = new int[n+m+2];

        for(int i = 0; i<n+m+2; i++){
            par[i] = i;
            size[i] = 1;
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<len; i++){
            int row = stones[i][0];
            int col = stones[i][1]+n+1;
            set.add(row);
            set.add(col);
            union(par, size, row, col);
        }
        int cnt = 0;
        for(int x : set){
            if(findPar(par, x) == x) cnt++;
        }

        return len-cnt;
    }
}
