// Another approach invloving sum of numbers and sum of squares of numbers but need to use BigInteger class for that
class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        int[] count = new int[arr.length+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            count[arr[i]]+=1;
        }
        int r = 0;
        int n = 0;
        for(int i = 1; i<=arr.length; i++){
            if(count[i]==2){
                r = i;
            }
            if(count[i]==0){
                n = i;
            }
        }
        list.add(r);
        list.add(n);
        return list;
    }
}
