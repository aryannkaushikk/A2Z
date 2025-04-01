Find Sum and Sum of sqaures for array elements and n natural numbers
Creates two equation for solving x,y

import java.util.* ;
import java.io.*; 
public class Solution {
	public static ArrayList<Integer> findMissingNumbers(ArrayList<Integer> arr, int n) {
		int m = arr.size();
        long sum1 = 0;
        long sum2 = 0;
        long sq1 = 0;
        long sq2 = 0;
        for(int i = 0; i<m; i++){
            sum1 += arr.get(i);
            sum2 += i+1;
            sq1 += (arr.get(i)*arr.get(i));
            sq2 += (i+1)*(i+1);
        }
        sum2 += ((m+2)+(m+1));
        sq2 += ((m+2)*(m+2))+((m+1)*(m+1));
        long a = sum2-sum1;
        long b = sq2-sq1;
        double sqrt = Math.sqrt(2*b-(a*a));
        int x = (int) ((a-sqrt)/2);
        int y = (int) ((a+sqrt)/2);
        ArrayList<Integer> list = new ArrayList<>();
		list.add(x);
		list.add(y);
		return list;
	}
}

