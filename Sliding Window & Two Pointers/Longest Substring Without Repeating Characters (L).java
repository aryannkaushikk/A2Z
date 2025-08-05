"""
Approach

Simple 2 Pointer Approach
Keep moving right pointer till you dont discover a duplicate character and that character's last occurence falls between left and right (otherwise it doesnt matter)
Then just put left to last occurence + 1
"""

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;
        int n = s.length();
        while (right < n) {
            char ch = s.charAt(right);
            if (map.containsKey(ch) && left <= map.get(ch)) {
                left = map.get(ch) + 1;
            }
            len = Math.max(len, right - left + 1);
            map.put(ch, right);
            right++;
        }
        return len;
    }
}
