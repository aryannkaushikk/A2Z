"""
Approach

Maintain a HashMap to count Frequency and size 
When size hits k check length using left-right pointer if size>k start decreasing from left
"""
  
class Solution {
    public int longestKSubstr(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size()==k) max = Math.max(max, right-left+1);
            while(map.size()>k && left<right){
                char x = s.charAt(left);
                if(map.get(x)==1) map.remove(x);
                else map.put(x, map.get(x)-1);
                left++;
            }
            right++;
        }
        return max;
    }
}
