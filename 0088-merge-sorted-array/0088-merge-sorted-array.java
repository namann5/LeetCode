class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        return fun(l,h);
    }

    fun(int l,int h){
        if(l<h){
            mid = (l+h)/2;
        }
        fun(l,mid);
        fun(mid+1,h);
        fun(l,mid,h);
    }
}