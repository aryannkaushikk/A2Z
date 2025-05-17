"""
Approach

In DP[i][j], if i==j (characters not indexes) then you put 1 + dp[i-1][j-1] which will be >=1 if substring was coming along
"""

"""
Tabulation
"""

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
  
"""
Space Optimisation
"""

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m+1];
        int max = 0;
        for(int i = 1; i<=n; i++){
            int[] temp = new int[m+1];
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                    max = Math.max(max, temp[j]);
                }
            }
            dp = temp;
        }
        return max;
    }
}
