class Solution {
    public boolean pHelper(int i , int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i = i+1;
            j= j-1;
        }
        return true;
    }
    // TC : O(n), SC : O(1);
    // abxba
    // i+1
    //     j-1

    public boolean validPalindrome(String s) {
        int i =0;
        int j = s.length() -1;
        
        while(i < j){
            char left = s.charAt(i);
            char right = s.charAt(j);

            if(left != right){
                // delete the character here in this condition
                return pHelper(i+1,j,s) || pHelper(i,j-1,s);
            }else {
                i = i +1;
                j = j -1;
            }
        }
        return true;
    }
}