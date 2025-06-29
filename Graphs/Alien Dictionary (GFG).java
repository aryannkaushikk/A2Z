"""
Approach

Topological Sort
The tricky part is building DAG's ADJ List from given words
Go Through each word and count unique ones and assign them index using hashmap
also in an array of size 26 store which character has what index for reverse mapping

Then go from i to i-1
For each i, i+1 pair
First diff character occured is a edge from i to i+1 character

after that you have your adj list
"""

class Solution {
    
    public String findOrder(String[] words) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] reverseMap = new char[26];
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!map.containsKey(word.charAt(j))) {
                    map.put(word.charAt(j), count);
                    reverseMap[count++] = word.charAt(j);
                }
            }
        }

        int[] indegree = new int[count];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean found = false;
            
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(map.get(c1)).add(map.get(c2));
                    indegree[map.get(c2)]++;
                    found = true;
                    break;
                }
            }
            
            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<count; i++){
            if(indegree[i]==0) q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        int count2 = 0;
        while(!q.isEmpty()){
            int V = q.poll();
            count2++;
            for(int i: adj.get(V)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
            
            sb.append(reverseMap[V]);
        }
        if(count2==count) return sb.toString();
        else return "";
    }
}
