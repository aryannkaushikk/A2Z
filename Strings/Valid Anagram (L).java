"""
Approach

Maintain a HashTable of 26 size every character from s adds and from t subtracts
Later iterate the array if any cell is not 0 means there is a diff in both strings
"""

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n!=m) return false;

        int[] map = new int[26];

        for(int i = 0; i<n; i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

        for(int i : map){
            if(i!=0) return false;
        }

        return true;
    }
}

"""
Bit more efficient way
"""
  
class Solution {
    public boolean isAnagram(String s, String t) {

      if(s.length()!= t.length()) return false;
      int[] freq = new int[26];

      for (char c : s.toCharArray()){
        freq[c - 'a']+=1;
      }

      for (char c : t.toCharArray()){

        if(freq[c - 'a'] ==0){
          return false;
        }
        else{
          freq[c-'a']-=1;
        }

      }
      return true;       
    }
}
