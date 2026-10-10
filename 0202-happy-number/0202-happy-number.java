class Solution {
    public boolean isHappy(int n) {
        int slow =n;
        int fast =n;

        while(fast != 1){
            slow = sum(slow);
            fast = sum(sum(fast));

            if(fast == 1){
                return true;
            }
            if(slow == fast){
                return false;
            }
        }
        return true;
    }

    public int sum(int n){
        int sum = 0;
        //36 /10 = 3--> 0;
        //digit = 3;
        // %10 = 6

        while(n > 0){
            int digit = n % 10;
            sum = sum + (digit * digit);
            n = n/10;

        }
        return sum;
    }
}