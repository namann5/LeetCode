class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end = arr.length-1;
        int res = -1;

        while(start <= end){
            int guess = (start + end)/2;

            if(arr[guess] < arr[guess +1]){
             start = guess +1;
            }else {
                res = guess;
                end = guess - 1;
            }
        }
        return res;
    }
}