"""
Approach

Same as Path question here you are just calculating using index, index-1 and index+1 of previous level
"""

"""
Recursion
"""

class Solution {

    static int minPath(int[][] matrix, int i, int j){
        if(j<0 || j>=matrix[0].length) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];

        int up = minPath(matrix, i-1, j);
        int left = minPath(matrix, i-1, j-1);
        int right = minPath(matrix, i-1, j+1);

        int min = Math.min(Math.min(left,right),up);

        return matrix[i][j] + min;
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            min = Math.min(minPath(matrix, m-1, i), min);
        }
        return min;
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int minPath(int[][] matrix, int i, int j, int[][] dp){
        if(j<0 || j>=matrix[0].length) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up = minPath(matrix, i-1, j, dp);
        int left = minPath(matrix, i-1, j-1, dp);
        int right = minPath(matrix, i-1, j+1, dp);

        int min = Math.min(Math.min(left,right),up);

        dp[i][j] = matrix[i][j] + min;

        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            min = Math.min(minPath(matrix, m-1, i, dp), min);
        }
        return min;
    }
}

"""
Tabulation
"""

class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0){
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int up = dp[i-1][j];
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(j>0) left = dp[i-1][j-1];
                if(j<n-1) right = dp[i-1][j+1];

                int min = Math.min(Math.min(left, right), up);

                dp[i][j] = matrix[i][j] + min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[m-1][i], min);
        }
        return min;
    }
}

"""
Space Optimisation
"""

class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = matrix[0];

        for (int i = 1; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int up = dp[j];
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(j>0) left = dp[j-1];
                if(j<n-1) right = dp[j+1];

                int min = Math.min(Math.min(left, right), up);

                temp[j] = matrix[i][j] + min;
            }
            dp = temp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
