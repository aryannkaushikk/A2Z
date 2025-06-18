"""
Approach

BFS/DFS just instead of matrix or list
check up/down/left/right
"""

class Solution {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    void bfs(char[][] grid, int vx, int vy, int[][] vis){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(vx,vy));

        while(!q.isEmpty()){
            Pair p = q.poll();
            vis[p.x][p.y] = 1;

            for(int x = -1; x<2; x+=2){
                if(p.x+x<0 || p.x+x>=grid.length) continue;
                if(grid[p.x+x][p.y]=='1' && vis[p.x+x][p.y]==0) q.offer(new Pair(p.x+x,p.y));
            }

            for(int y = -1; y<2; y+=2){
                if(p.y+y<0 || p.y+y>=grid[0].length) continue;
                if(grid[p.x][p.y+y]=='1' && vis[p.x][p.y+y]==0) q.offer(new Pair(p.x,p.y+y));
            }
        }
    }

    void dfs(char[][] grid, int vx, int vy, int[][] vis){
        if(vis[vx][vy]==1) return;

        vis[vx][vy]=1;
        
        for(int x = -1; x<2; x+=2){
            if(vx+x<0 || vx+x>=grid.length) continue;
            if(grid[vx+x][vy]=='1') dfs(grid, vx+x, vy, vis);
        }

        for(int y = -1; y<2; y+=2){
            if(vy+y<0 || vy+y>=grid[0].length) continue;
            if(grid[vx][vy+y]=='1') dfs(grid, vx, vy+y, vis);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    dfs(grid, i, j, vis);
                    count++;
                } 
            }
        }
        return count;
    }
}
