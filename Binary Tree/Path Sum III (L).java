"""
Approach

Simple Two Sum kinda approach using Prefix Sum HashMap for each Path
"""

class Solution {

    int pathCounter(TreeNode root, long targetSum, long currSum, Map<Long, Integer> map){
        if(root==null) return 0;

        long sum = currSum+root.val;
        int count = 0; 
        count += map.getOrDefault(sum-targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);

        int left = pathCounter(root.left, targetSum, sum, map);
        int right = pathCounter(root.right, targetSum, sum, map);

        if(map.get(sum)==1) map.remove(sum);
        else map.put(sum, map.get(sum)-1);

        return count+left+right;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        return pathCounter(root, targetSum, 0, map);
    }
}
