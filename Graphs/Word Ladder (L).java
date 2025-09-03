"""
Approach

Use BFS and for each level check each word by changing character at everyplace for next possible words
When endWord found return
"""

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-- > 0){
                String word = q.poll();
                char[] arr = word.toCharArray();
                for(int i = 0; i<arr.length; i++){
                    char curr = arr[i];
                    for(char x = 'a'; x<='z'; x++){
                        if(curr==x) continue;
                        arr[i] = x;
                        String newWord = new String(arr);
                        if(set.contains(newWord)){
                            if(newWord.equals(endWord)) return level;
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    arr[i] = curr;
                }
            }
        }
        return 0;
    }
}
