"""
Approach

This question involves using Hash Table + Sorting (or Using PQ)

So What we are doing is creating a HashTable noting frequency of each element, then using lowest element we start to create each group by iterating from that val+0 to val+groupSize
"""

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }

        Arrays.sort(hand);

        for(int card: hand) {
            int count = map.get(card);
            if(count > 0){
                for(int i = 0; i<groupSize; i++){
                    if(map.getOrDefault(card+i,0) < count) return false;
                    map.put(card+i, map.get(card+i)-count);
                }
            }
        }

        return true;
    }
}
