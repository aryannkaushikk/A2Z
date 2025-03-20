// Similar to Banana Pile Question

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<bloomDay.length; i++){
            if(min>bloomDay[i]){
                min = bloomDay[i];
            }
            if(max<bloomDay[i]){
                max = bloomDay[i];
            }
        }
        int days = Integer.MAX_VALUE;
        while(min<=max){
            int mid = (min+max)/2;
            int bouquet = 0;
            int count = 0;
            for(int i = 0; i<bloomDay.length; i++){
                if(bloomDay[i]-mid<=0){
                    count++;
                }else{
                    count = 0;
                }
                if(count==k){
                    bouquet++;
                    count=0;
                }
            }
            if(bouquet<m){
                min = mid+1;
            }else{
                days = Math.min(days,mid);
                max = mid-1;
            }
        }
        if(days==Integer.MAX_VALUE){
            return -1;
        }
        return days;
    }
}
