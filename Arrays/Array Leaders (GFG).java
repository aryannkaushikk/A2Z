// Since last element is always a leader you will add it to list and maintain a max which is initially last element.
// Iterate from n-2 and when element>max add to list and set max = element.
// In the end reverse the list to return in same order.

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = arr[arr.length-1];
        list.add(max);
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i]>=max){
                max = arr[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
