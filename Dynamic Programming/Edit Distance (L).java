"""
Approach

If same elements, you got i-1, j-1
If not then you try all 3:
  1. Insert -> if you inserted that means j is done move to i,j-1
  2. Delete -> if you delete that means i is deleted move to i-1,j
  3. Replace -> if you replace that means you made same elements so move to i-1,j-1

If i<0 that means j+1 elements need to be added
If j<0 that means i+1 elements need to be deleted
"""

"""
Recursion
"""

class Solution {

    static int edit(String s1, String s2, int i, int j){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)){
            return edit(s1, s2, i-1, j-1);
        }

        int ins = 1 + edit(s1, s2, i, j-1);
        int del = 1 + edit(s1, s2, i-1, j);
        int rep = 1 + edit(s1, s2, i-1, j-1);

        return Math.min(Math.min(ins, del), rep);
    }

    public int minDistance(String word1, String word2) {
        return edit(word1, word2, word1.length()-1, word2.length()-1);
    }
}
  
"""
Recursion + Memoization
"""

class Solution {

    static int edit(String s1, String s2, int i, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = edit(s1, s2, i-1, j-1, dp);
        }

        int ins = 1 + edit(s1, s2, i, j-1, dp);
        int del = 1 + edit(s1, s2, i-1, j, dp);
        int rep = 1 + edit(s1, s2, i-1, j-1, dp);

        return dp[i][j] = Math.min(Math.min(ins, del), rep);
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return edit(word1, word2, n-1, m-1, dp);
    }
}
  
"""
Tabulation
"""

class Solution {

    static int edit(String s1, String s2, int i, int j, int[][] dp){
        if(i==0) return j+1;
        if(j==0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = edit(s1, s2, i-1, j-1, dp);
        }

        int ins = 1 + edit(s1, s2, i, j-1, dp);
        int del = 1 + edit(s1, s2, i-1, j, dp);
        int rep = 1 + edit(s1, s2, i-1, j-1, dp);

        return dp[i][j] = Math.min(Math.min(ins, del), rep);
    }

    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j<=m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                int ins = 1 + dp[i][j-1];
                int del = 1 + dp[i-1][j];
                int rep = 1 + dp[i-1][j-1];

                dp[i][j] = Math.min(Math.min(ins, del), rep);
            }
        }
        return dp[n][m];
    }
}
  
"""
Space Optimisation
"""

class Solution {

    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m+1];
        for(int i = 0; i<=m; i++){
            dp[i] = i;
        }
        for(int i = 1; i<=n; i++){
            int[] temp = new int[m+1];
            temp[0] = i;
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[j] = dp[j-1];
                    continue;
                }

                int ins = 1 + temp[j-1];
                int del = 1 + dp[j];
                int rep = 1 + dp[j-1];

                temp[j] = Math.min(Math.min(ins, del), rep);
            }
            dp = temp;
        }
        return dp[m];
    }
}
