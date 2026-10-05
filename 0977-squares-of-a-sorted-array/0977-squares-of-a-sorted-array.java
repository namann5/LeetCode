class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i =0;
        int j = n-1;

        int k = nums.length -1;

        /*
        [-3, - 2, 0, 1, 4]
        i+1
                    j-1
        [0,1,4,9,16]
                  k-1  

        TC : O(n);
        SC = O(1);           
         */

        while( i<= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j]) ){
                res[k] = nums[i] * nums[i];
            i= i+1;
            }
            else {
                res[k] = nums[j]* nums[j];
                j = j-1;
            }
            k = k -1;
        }
        return res;
    }
}