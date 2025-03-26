// Sort the Array on the basis of 1st element of each row
// Add starting row to list and store it in some var temp
// Now if next row's first element is less than equal to temp array's last element then temp's last element = Max (current array last element, temp array last element)
// else add array to list and store in temp.

class Solution {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int i = 1;
        List<int[]> list = new LinkedList<>();
        int[] temp = intervals[0];
        list.add(temp);
        while(i<n){
            if(intervals[i][0]<=temp[1]){
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }else{
                temp = intervals[i];
                list.add(temp);
            }
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
