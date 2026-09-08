class Solution {
    public int hammingWeight(int n) {
        int res =0;

        while(n != 0){
            res++;
            n= n & (n-1); ///Har iteration mein rightmost 1 bit remove kar deta hai.
        } 
        return res;
    }
}