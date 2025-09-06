"""
Approach

Topological Sort
Build Graph as
First add node for each character in HashMap
Then for Each pair of word 
when word1 and word2 gets difference that means word1 character comes before word2 character so add it to HashMap
Also track indegree
Also if word1 is shorter than word2 and word1 has prefix of word2 then its invalid dictionary

Lastly apply simple topological sort
"""

class Solution {
    public String findOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        
        for(int j = 0; j<words.length-1; j++){
            String word1 = words[j];
            String word2 = words[j+1];
            
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; 
            }
            
            int i = 0;
            while(i<word1.length() && i<word2.length()){
                if(word1.charAt(i)!=word2.charAt(i)){
                    char u = word1.charAt(i);
                    char v = word2.charAt(i);
                    adj.putIfAbsent(u, new ArrayList<>());
                    adj.putIfAbsent(v, new ArrayList<>());
                    indegree.putIfAbsent(u, 0);
                    indegree.putIfAbsent(v, 0);
                    adj.get(u).add(v);
                    indegree.put(v, indegree.get(v)+1);
                    break;
                }
                i++;
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : indegree.entrySet()){
            if(entry.getValue()==0) q.offer(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char node = q.poll();
            sb.append(node);
            for(char neigh : adj.get(node)){
                indegree.put(neigh, indegree.get(neigh)-1);
                if(indegree.get(neigh)==0) q.offer(neigh);
            }
        }
        return sb.length()==adj.size() ? sb.toString() : "";
    }
}
