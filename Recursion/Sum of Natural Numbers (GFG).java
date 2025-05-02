class Solution {
    public static int seriesSum(int n) {
        if(n==1) return n;
        return n+seriesSum(n-1);
    }
}
