"""
Approach

If i==j then pick i.e. call for i-1,j-1 and you have to always call for i-1,j (no pick) return their sum
If j<0 return 1 (we have picked each target character from source)
If i<0 return 0 (we reached end of source but couldnt pick all characters from target)
"""
  
"""
Recursion
"""

class Solution {

    static int lcs(String s, String t, int i, int j){
        if(j<0) return 1;  
        if(i<0) return 0;

        int pick = 0;

        if(s.charAt(i)==t.charAt(j)){
            pick = lcs(s, t, i-1, j-1);
        }

        return pick + lcs(s, t, i-1, j);
    }

    public int numDistinct(String s, String t) {
        return lcs(s, t, s.length()-1, t.length()-1);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int lcs(String s, String t, int i, int j, int[][] dp){
        if(j<0) return 1;  
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int pick = 0;

        if(s.charAt(i)==t.charAt(j)){
            pick = lcs(s, t, i-1, j-1, dp);
        }

        return dp[i][j] = pick + lcs(s, t, i-1, j, dp);
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return lcs(s, t, n-1, m-1, dp);
    }
}

"""
Tabulation
"""

class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n<m) return 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                int pick = 0;

                if(s.charAt(i-1)==t.charAt(j-1)){
                    pick = dp[i-1][j-1];
                }

                dp[i][j] = pick + dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}  

"""
Space Optimisation
"""

class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n<m) return 0;
        int[] dp = new int[m+1];
        for(int i = 0; i<n; i++){
            dp[0] = 1;
        }
        for(int i = 1; i<=n; i++){
            int[] temp = new int[m+1];
            temp[0] = 1;
            for(int j = 1; j<=m; j++){
                int pick = 0;

                if(s.charAt(i-1)==t.charAt(j-1)){
                    pick = dp[j-1];
                }

                temp[j] = pick + dp[j];
            }
            dp = temp;
        }
        return dp[m];
    }
}
