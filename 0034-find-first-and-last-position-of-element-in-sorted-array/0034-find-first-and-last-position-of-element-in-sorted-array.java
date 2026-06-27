class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOcr(nums, target);
        int last = lastOcr(nums,target);

        return new int[]{first,last};
    }

        private int firstOcr(int[] nums, int target){
            int low=0;
            int n = nums.length;
            int high = n-1;
            int res = -1;

            while(low <= high){
                int guess = (low+high)/2;

                if(nums[guess] < target){
                    low = guess +1;
                }else if(nums[guess] > target){
                    high = guess -1;
                }else {
                    res = guess;
                    high = guess- 1;
                }
            }
            return res;
        }

        private int lastOcr(int[] nums, int target){
            int low=0;
            int n = nums.length;
            int high = n-1;
            int res = -1;

            while(low <= high){
                int guess = (low+high)/2;

                if(nums[guess] < target){
                    low = guess +1;
                }else if(nums[guess] > target){
                    high = guess -1;
                }else {
                    res = guess;
                    low = guess + 1;
                }
            }
            return res; 
        }  

}