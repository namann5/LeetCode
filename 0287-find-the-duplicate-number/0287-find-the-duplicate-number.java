class Solution {
    public int findDuplicate(int[] nums) {
        //1 3 4 2 2 --> 5
        // n =4

        // 1 2 2 2 2 --> 5
        // n=4

        //TC : O(n), SC : O(1)
         int slow =0,
            fast =0;

            do{
                slow = nums[slow];
                fast = nums[fast];
                fast = nums[fast];

                if(slow == fast){
                    break;
                }
                
            } while(slow != fast);

            int n1 = 0;
            int n2= slow;

            while(n1 != n2){
                n1 = nums[n1];
                n2 = nums[n2];
            }


        return n1;
    }
}