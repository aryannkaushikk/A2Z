"""
Approach

Mapping frequency of each character then storing in a PQ according to frequeuncy.
Then Emptying PQ 
"""

class Solution {

    static class Pair{
        char ch;
        int freq;

        public Pair(char c, int x){
            this.ch = c;
            this.freq = x;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            char ch = p.ch;
            int freq = p.freq;
            for(int i = 0; i<freq; i++) sb.append(ch);
        }
        return sb.toString();
    }
}
