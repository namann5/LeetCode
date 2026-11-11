class Solution {
    public int trap(int[] height) {
        int l =0;
        int r = height.length-1;
        int lMax = 0,
            rMax = 0,
            water =0;

            while(l<r){
                if(height[l] < height[r]){
                    lMax = Math.max(lMax, height[l]);
                    water += lMax - height[l];
                    l++;
                }else {
                    rMax = Math.max(rMax, height[r]);
                    water += rMax - height[r];
                    r--;
                }
            }
            return water;
    }
}