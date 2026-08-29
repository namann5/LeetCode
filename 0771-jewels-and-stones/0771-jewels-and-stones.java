class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean [] jewel = new boolean[128];
        int count=0;

        for(char ch : jewels.toCharArray()){
            jewel[ch] = true;
        }

        for(char ch : stones.toCharArray()){
            if(jewel[ch]){
                count++;
            }
        }
        return count;
    }
}