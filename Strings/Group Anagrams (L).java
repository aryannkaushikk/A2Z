"""
Approach

Use HashMap where key is sorted String and value is a list of string which when sorted equals to key
"""

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            String x = strs[i];
            char[] temp = x.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(x);
        }

        return new ArrayList<>(map.values());
    }
}
