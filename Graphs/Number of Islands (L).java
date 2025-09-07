"""
Approach

BFS/DFS and dont keep vis instead use grid and switch visited cells to '0'
"""

class Solution {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';

        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]=='1') dfs(grid, nx, ny);
        }
    }


    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
