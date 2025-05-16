"""
Approach

If current characters are same, then return 1 + go to i-1, j-1
Else return Max of (i-1,j) and (i, j-1) i.e. try to see if current element in either could give higher value with other character in other string
"""

"""
Recursion
"""

class Solution {

    static int lcs(String s1, String s2, int i, int j){
        if(i<0 || j<0) return 0;
        
        if(s1.charAt(i)==s2.charAt(j)){
            return 1 + lcs(s1, s2, i-1, j-1);
        }

        return Math.max(lcs(s1, s2, i, j-1), lcs(s1, s2, i-1, j));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length()-1, text2.length()-1);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int lcs(String s1, String s2, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1 + lcs(s1, s2, i-1, j-1, dp);
        }

        return dp[i][j] = Math.max(lcs(s1, s2, i, j-1, dp), lcs(s1, s2, i-1, j, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i][j];
        for(int x = 0; x<i; x++){
            Arrays.fill(dp[x], -1);
        }
        return lcs(text1, text2, i-1, j-1, dp);
    }
}

"""
Tabulation

If each element is shifted one step ahead, 0 becomes 1, 1 becomes 2, and so -1 becomes 0
The base case if (i<0 || j<0) return 0 changes to if(i==0 || j==0) return 0
Now we can apply base case in tabulation
Just change in checking of characters
s1.charAt(i) ---> s1.charAt(i-1);
"""

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}

"""
Space Optimisation
"""

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m+1];
        for(int i = 1; i<=n; i++){
            int[] temp = new int[m+1];
            for(int j = 1; j<=m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                    continue;
                }

                temp[j] = Math.max(temp[j-1], dp[j]);
            }
            dp = temp;
        }
        return dp[m];
    }
}
