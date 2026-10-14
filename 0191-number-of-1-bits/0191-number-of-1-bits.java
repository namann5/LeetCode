class Solution {
    public int hammingWeight(int n) {
        int a =0;

        while(n != 0){
            a++;
            n = n & (n-1);
        }
        return a;
    }
}