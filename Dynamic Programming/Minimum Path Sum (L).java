"""
Approach

Just like unique paths but instead now we want minimum path sum
So Minimum path sum to reach a,b is minimum of path sum between the cell above and the cell on left
And since we are doing minimum if range goes out of 0 return Integer.MAX_VALUE
"""

"""
Recursion
"""

class Solution {

    static int path(int[][] grid, int i, int j){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[0][0];

        int up = path(grid, i-1, j);
        int left = path(grid, i, j-1);

        return grid[i][j] + Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return path(grid, m-1, n-1);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int path(int[][] grid, int i, int j, int[][] dp){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[0][0];

        if(dp[i][j]!=-1) return dp[i][j];

        int up = path(grid, i-1, j, dp);
        int left = path(grid, i, j-1, dp);

        dp[i][j] = grid[i][j] + Math.min(up, left); 
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return path(grid, m-1, n-1, dp);
    }
}

"""
Tabulation
"""

class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    if(i>0) up = dp[i-1][j];
                    int left = Integer.MAX_VALUE;
                    if(j>0) left = dp[i][j-1];

                    dp[i][j] = grid[i][j] + Math.min(up,left);
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

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i<m; i++){
            int[] temp = new int[n];
            for(int j = 0; j<n; j++){
                if(i==0 && j==0) temp[j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    if(i>0) up = dp[j];
                    int left = Integer.MAX_VALUE;
                    if(j>0) left = temp[j-1];

                    temp[j] = grid[i][j] + Math.min(up,left);
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
