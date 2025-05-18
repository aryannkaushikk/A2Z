"""
Approach

First we need the 2D DP table of LCS of the 2 strings fulfilled via tabulation
Then start from n,m
If n==m then add the character and move n-1,m-1
else if n-1,m>n,m-1 add character n and move to n-1,m
else add character m and move to n,m-1

In end while n>0 add n to ans AND while m>0 add m to ans
"""

"""
Tabulation
"""

class Solution {
    
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n;
        int j = m;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                ans.append(s1.charAt(i-1));
                i--;
            }else{
                ans.append(s2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            ans.append(s1.charAt(i-1));
            i--;
        }

        while(j>0){
            ans.append(s2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}
