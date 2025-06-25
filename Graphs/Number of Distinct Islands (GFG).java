"""
Approach

Same as Number of Provinces but this time we store shape of each province and that in a set
Size of set is number of distinct islands
To store the shape, move in same manner, store in a list of string as (x,y)
where x is diff of base cell row and current cell row
      y is diff of base cell col and current cell col
"""

// User function Template for Java

class Solution {
    
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    
    String toString(int r, int c){
        return Integer.toString(r) + ' ' + Integer.toString(c); 
    }
    
    void dfs(int bx, int by, int[][] grid, int cx, int cy, int[][] vis, List<String> list){
        if(vis[cx][cy]==1) return;
        
        vis[cx][cy] = 1;
        list.add(toString(cx-bx, cy-by));
        for(int d = 0; d<4; d++){
            if(cx+dx[d]>=0 && cx+dx[d]<grid.length && cy+dy[d]>=0 && cy+dy[d]<grid[0].length && grid[cx+dx[d]][cy+dy[d]]==1) dfs(bx, by, grid, cx+dx[d], cy+dy[d], vis, list);
        }
    }

    int countDistinctIslands(int[][] grid) {
        Set<List<String>> set = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    List<String> temp = new ArrayList<>();
                    dfs(i,j, grid, i,j, vis, temp);
                    set.add(temp);
                }
            }
        }
        
        return set.size();
    }
}
