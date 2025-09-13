"""
Approach

In the matrix each cell is a node,
To provide each cell a unique node Id we used x*m+y where x is x-coordinate, m is number of columns and y is y-th coordinate
So we use disjoint set and par array is 1D array of size n*m
For each cell increase count at first then for each positive union decrease it by checking if land in all 4 directions
"""

public class Solution {

    static int findPar(int[] par, int x){
        if(par[x]==x) return x;
        return par[x] = findPar(par, par[x]);
    }

    static boolean union(int[] par, int x, int y){
        int px = findPar(par, x);
        int py = findPar(par, y);
        if(px==py) return false;
        else{
            par[px] = py;
            return true;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        int[] par = new int[n*m];
        for(int i = 0; i<n*m; i++) par[i] = i;
        int[][] vis = new int[n][m];
        int currCount = 0;
        int[] count = new int[q.length];
        for(int i = 0; i<q.length; i++){
            int x = q[i][0];
            int y = q[i][1];
            int node = x*m+y;
            if(vis[x][y]==1) continue;
            vis[x][y] = 1;
            currCount++;
            for(int d = 0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                int newNode = nx*m+ny;
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==1 && union(par, node, newNode)) currCount--;
            }
            count[i] = currCount;
        }
        return count;
    }
}
