class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double avg = 0;
        double sum =0;
        for(int i =0;i<k;i++){
            sum = sum + nums[i];
        }
        avg = sum/k;
        max = Math.max(max,avg);

        for(int i = k;i< nums.length;i++){
            //         expand the window 
            //                    reduce the window  
            sum = sum + nums[i] - nums[i-k];
            avg = sum/k;
            max = Math.max(max,avg);
           
        }
        return max;
    }
}