"""
Approach

The number of unique Paths to reach a,b is the sum of number of unique paths to reach the cell above it and on its left
"""

"""
Recursion  
"""
class Solution {

    public static int paths(int i, int j, int m, int n){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        return paths(i-1,j,m,n)+paths(i,j-1,m,n);
    }

    public int uniquePaths(int m, int n) {
        return paths(m-1,n-1,m,n);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    public static int paths(int i, int j, int m, int n, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j] = paths(i-1,j,m,n,dp)+paths(i,j-1,m,n,dp);
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return paths(m-1,n-1,m,n, dp);
    }
}

"""
Tabulation
"""

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0 || j==0){
                  dp[i][j] = 1;
                  continue;
                }
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
}

"""
Space Optimisation
"""

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0; i<m; i++){
            int[] temp = new int[n];
            for(int j = 0; j<n; j++){
                if(i==0 || j==0){
                    temp[j] = 1;
                    continue;
                }  
                int up = dp[j];
                int left = temp[j-1];
                temp[j] = up+left;
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
