class Solution {
    public int trap(int[] height) {
        //ehh??
        int n = height.length;
        int low = 0;
        int high = n-1;
        int maxLow =0;
        int maxHigh = 0;
        int water =0;

        while(low < high){
            if(height[low] < height[high]){
                maxLow = Math.max(maxLow, height[low]);
                water += maxLow - height[low];
                low++;
            }else {
                maxHigh = Math.max(maxHigh , height[high]);
                water += maxHigh - height[high];
                high--;
            }
        }
        return water;
    }
}