// Another approach invloving sum of numbers and sum of squares of numbers but need to use BigInteger class for that
// In that approach you create two equations:
// 1. (Sum of n numbers) - (Sum of all elements in array) -> x+y
// 2. (Sum of sqaure of n numbers) - (Sum of sqaures of all elements in array) -> x^2 + y^2
// Solve equations and you have x = missing number and y = repeating number

// In this approach, I am simply storing 1 for all elements that appeared from 1 to n.
// There will be a zero for one that did not appear and 2 for one that occured twice.

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
