"""
Approach

Map Each elements frequency
Then from right to left iterate and maintain elements in stack from bottom to top in decreasing order of frequency
"""

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int val = arr[i];
            if(!map.containsKey(val)) map.put(val, 1);
            else map.put(val, map.get(val)+1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int[] s = new int[n];
        int top = -1;
        for(int i = n-1; i>=0; i--){
            int freq = map.get(arr[i]);
            while(top!=-1 && map.get(s[top])<=freq){
                top--;
            }
            if(top==-1) ans.add(-1);
            else ans.add(s[top]);
            s[++top] = arr[i];
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}
