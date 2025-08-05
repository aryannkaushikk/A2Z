"""
Approach

Simple 2 Pointer Approach
Keep moving right pointer till you dont discover a duplicate character
If you do move left to the last occurence of that character and remove every character on your way from map
Then just put left to last occurence + 1
"""

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;
        int n = s.length();
        while(right<n){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                int id = map.get(ch);
                while( left != id ) {
                    if(map.containsKey(s.charAt(left))) map.remove(s.charAt(left++));
                }
                left = id+1;
            }
            len = Math.max(len, right-left+1);
            map.put(ch, right);
            right++;
        }
        return len;
    }
}
