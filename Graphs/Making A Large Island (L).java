"""
Approach

Use Disjoint Set
Mark each cell as a Node and use union to make components firstly
Then for each 0 cell check unique parents in all 4 directions where cell is 1
and Sum size of unique parents + 1 and check for Max
"""


class Solution {

    int findPar(int[] par, int x){
        if(par[x]==x) return x;
        return par[x] = findPar(par, par[x]);
    }

    int union(int[] par, int[] size, int a, int b){
        int pa = findPar(par, a);
        int pb = findPar(par, b);
        if(pa==pb) return 0;
        else{
            if(size[pa]>size[pb]){
                par[pb] = pa;
                size[pa] += size[pb];
                return size[pa];
            }else{
                par[pa] = pb;
                size[pb] += size[pa];
                return size[pb];
            }
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxSize = n*m;

        if(maxSize==1) return 1;

        int[] par = new int[maxSize];
        int[] size = new int[maxSize];
        
        for(int i = 0; i < maxSize; i++){
            par[i] = i;
            size[i] = 1;
        }

        int maxSum = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==0) continue;
                int node = i*m+j;
                for(int d = 0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    int node2 = nx*m+ny;
                    if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                        int s = union(par, size, node, node2);
                        if(maxSum<s) maxSum = s;
                    }
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1) continue;
                int node = i*m+j;
                Set<Integer> set = new HashSet<>();
                for(int d = 0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    int node2 = nx*m+ny;
                    if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                        int parent = findPar(par, node2);
                        set.add(parent);
                    }
                }
                int sum = 1;
                for(int p : set) sum += size[p];
                if(maxSum<sum) maxSum=sum;
            }
        }
        return maxSum;
    }
}
