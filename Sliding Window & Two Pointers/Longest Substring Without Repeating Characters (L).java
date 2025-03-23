// If not in map move r after calculating max len
// If it is then move l +1 to where last current character occured if it is greater or equal to l

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int l = 0;
        int r = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c) && l<=map.get(c)){
                l = map.get(c)+1;   
            }
            map.put(c,r);
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
