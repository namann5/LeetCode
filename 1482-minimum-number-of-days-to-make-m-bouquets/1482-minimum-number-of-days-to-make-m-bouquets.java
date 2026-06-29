class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
         return -1;
        }

        int low =Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int x : bloomDay){
            low = Math.min(x, low);
            high = Math.max(x,high);
        }

        int ans = high;

        while(low <= high){
            int guess = (low + high)/2;

            if(isPossible(bloomDay,m,k,guess)){
                ans = guess;
                high = guess -1;
            }else {
                low = guess + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] blooms,  int m, int k ,int day){
        int flowers =0;
        int boquet = 0;

        for(int bloom : blooms){
            if(bloom <= day){
                flowers++;
            }else {
                
                flowers =0;
            }
            if(flowers == k){
                 boquet++;
                  flowers = 0;
            }
        }
        return boquet >= m;
    }
}