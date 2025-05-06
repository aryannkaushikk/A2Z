"""
Approach

Same as part I just return 0 if you hit an obstacle i.e the path ends there
"""

"""
Recursion
"""

class Solution {

    static int paths(int[][] grid, int i, int j){
        if(i<0 || j<0) return 0;
        if(grid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;

        return paths(grid, i-1,j)+paths(grid, i, j-1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return paths(obstacleGrid, m-1, n-1);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int paths(int[][] grid, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(grid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        
        dp[i][j] = paths(grid, i-1,j, dp)+paths(grid, i, j-1, dp); 
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return paths(obstacleGrid, m-1, n-1, dp);
    }
}

"""
Tabulation
"""

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j]==1) dp[i][j] = 0;
                else if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int up = 0;
                    if(i>0) up = dp[i-1][j]; 
                    int left = 0; 
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

"""
Space Optimisation
"""

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i<m; i++){
            int[] temp = new int[n];
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j]==1) temp[j] = 0;
                else if(i==0 && j==0) temp[j] = 1;
                else{
                    int up = dp[j]; 
                    int left = 0; 
                    if(j>0) left = temp[j-1];
                    temp[j] = up+left;
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
