class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n = nums.length;
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i<n; i++){
            map.add(nums[i]);
        }
        int max = 0;
        int count = 1;
        for(int i: map){
            if(!map.contains(i-1)){
                int x = i+1;
                count = 1;
                while(map.contains(x)){
                    count++;
                    x++;
                }
                max = Math.max(count,max);
            }
        }
        return max;
        
        // Arrays.sort(nums);
        // int count = 1;
        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i<nums.length-1; i++){
        //     if(nums[i]==nums[i+1]){
        //         continue;
        //     }
        //     if(nums[i]+1!=nums[i+1]){
        //         max = Math.max(count,max);
        //         count = 1;
        //         continue;
        //     }
        //     count++;
        // }
        // max = Math.max(count,max);
        // return max;
    }
}
