class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        int size =0;

        for(int x : nums){
            int low =0;
            int high = size;

            while(low < high){
                int mid = low + (high - low)/2;

                if(res[mid] < x){
                    low = mid +1;
                }else {
                    high = mid;
                }
            }
            res[low] = x;

            if(low == size) size++;
        }
        return size;
        
        
    }
}