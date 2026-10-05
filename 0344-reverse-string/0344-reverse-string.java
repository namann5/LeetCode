class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length -1;

        /*
        s = [o,l,l,e,h]
        i+1;
                    j-1;
        temp = h;            
        TC : O(n);
        SC : O(1);
        */
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j]  = temp;

            i= i +1;
            j= j-1;
        }
    }
}