"""
Approach

Start from major currency possible to subtract from given n, subtract till possible then reach next greatest possible
Then decrease till n not 0
"""
import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> list = new LinkedList<>();
        int i = coins.length-1;
        while(n>0){
            while(coins[i]>n){
                i--;
            }
            while(coins[i]<=n){
                list.add(coins[i]);
                n -= coins[i];
            }
        }
        return list;
    }
}
