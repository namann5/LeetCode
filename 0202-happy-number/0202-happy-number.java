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
        int sum =0;

        while(n>0){
            int dight = n % 10;
            sum = sum + (dight*dight);
            n = n/10;
        }
        return sum;
    }
}