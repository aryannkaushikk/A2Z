// Another approach is nCr based
// But I have used list and since first list is 1 and second is 1,1. I start if numRows>=3 is required.
// I use pointer and point left at starting of previous list and till we iterate full size of last list.
// Store left+1 in right. 
// Store left+right in the current row list.
// Put right in left.
// Repeat till loop ends and at end put new list in Nested List.

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        list.add(temp);
        if(numRows==1){
            return list;
        }
        temp = new LinkedList<>();
        temp.add(1);
        temp.add(1);
        list.add(temp);
        if(numRows==2){
            return list;
        }
        numRows-=2;
        int k = 1;
        while(k<=numRows){
            List<Integer> prev = list.get(k);
            int i = 0;
            int j = prev.size()-1;
            temp = new LinkedList<>();
            int l = prev.get(i);
            temp.add(prev.get(i));
            int r = 0;
            while(i<j){
                r = prev.get(i+1);
                temp.add(l+r);
                l = r;
                i++;
            }
            k++;
            temp.add(l);
            list.add(temp);
        }
        return list;
    }
}
