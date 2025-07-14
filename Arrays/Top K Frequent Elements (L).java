"""
Approach

First Count frequencies using Map
Then use Bucket Sort to get Top K
"""

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new ArrayList[n+1];
        for(int i = 0; i<=n; i++) bucket[i] = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int count = 0;
        for(int i = n; i>=0; i--){
            if (bucket[i].size()!=0){
                for(int x: bucket[i]){
                    ans[count++] = x;
                    if(count==k) return ans;
                }
            } 
        }

        return ans;
    }
}
