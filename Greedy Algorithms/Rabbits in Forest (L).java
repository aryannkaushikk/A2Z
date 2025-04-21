"""
Approach

Count the rabbits and they can be divided into groups by dividing with x+1
So no. of groups x num+1 = total rabbits
"""

class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<n; i++){
            map.put(answers[i], map.getOrDefault(answers[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int val = entry.getValue();
            int key = entry.getKey();
            count += Math.ceil( (val + key) / (key+1) ) * (key+1);
        }
        return count;
    }
}
