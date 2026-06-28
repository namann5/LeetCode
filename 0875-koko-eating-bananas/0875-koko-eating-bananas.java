class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int low =1;
     int high =0;
     

     for(int pile : piles) {
        high = Math.max(high,pile);
     }  
        int ans = high;

        while(low <= high){
            int guess = (low + high)/2;
            long hour =0;

            for(int pile : piles){
                hour += (pile + guess -1)/guess;
            }

            if(hour <= h){
                ans = guess;
                high = guess -1;
            }else {
                low = guess +1;
            }
        }
        return ans;
    }
}