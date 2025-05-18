"""
Approach

If i==j, move i-1, j-1
If j=='?', move i-1, j-1
If j=='*', move i,j-1 (meaning im assuming * is "") OR move i-1,j (meaning im assuming * included ith character)
else return false

Base Cases:
  1. If i<0 && j<0 return true (strings matched)
  2. If i>=0 && j<0 return false (pattern exhausted)
  3. If i<0 && j>=0 then if 0 to j is only * then true else false
"""

"""
Recursion
"""

class Solution {

    static boolean match(String s, String p, int i, int j){
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0){
            for(int x = j; x>=0; x--){
                if(p.charAt(x)!='*') return false;
            }
            return true;
        }


        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return match(s, p, i-1, j-1);
        }else if(p.charAt(j)=='*'){
            return match(s, p, i-1, j) || match(s, p, i, j-1);
        }else{
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        return match(s, p, s.length()-1, p.length()-1);
    }
}
  
"""
Recursion + Memoization
"""

class Solution {

    static boolean match(String s, String p, int i, int j, Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0){
            for(int x = j; x>=0; x--){
                if(p.charAt(x)!='*') return false;
            }
            return true;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j] = match(s, p, i-1, j-1, dp);
        }else if(p.charAt(j)=='*'){
            return dp[i][j] = match(s, p, i-1, j, dp) || match(s, p, i, j-1, dp);
        }else{
            return dp[i][j] = false;
        }
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return match(s, p, n-1, m-1, dp);
    }
}
  
"""
Tabulation
"""

class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 1; i<=m; i++){
            if(p.charAt(i-1)!='*') break;
            dp[0][i] = true;
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
  
"""
Space Optimisation
"""

class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        for(int i = 1; i<=m; i++){
            if(p.charAt(i-1)!='*') break;
            dp[i] = true;
        }
        for(int i = 1; i<=n; i++){
            boolean[] temp = new boolean[m+1];
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    temp[j] = dp[j-1];
                }else if(p.charAt(j-1)=='*'){
                    temp[j] = dp[j] || temp[j-1];
                }else{
                    temp[j] = false;
                }
            }
            dp = temp;
        }
        return dp[m];
    }
}
  
