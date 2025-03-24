// Maintain maxFreq with each time r moves
// When length (r-l+1) - maxFreq>k decrease the substring by 1 size since we want a size greater than what we have so no point shrinking totally.
// Use an array instead of HashMap as we dont need to check size.

class Solution {

    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        int maxFreq = 0;
        int[] map = new int[27];
        while(r<s.length()){
            char c = s.charAt(r);
            map[(int) c - 'A']++;
            maxFreq = Math.max(maxFreq,map[(int) c - 'A']);
            if(r-l+1 - maxFreq>k){
                char temp = s.charAt(l);
                map[(int) temp - 'A']--;
                l++;
            }
            max = Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}
