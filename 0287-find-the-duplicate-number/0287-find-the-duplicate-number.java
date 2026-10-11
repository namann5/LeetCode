class Solution {
    public int findDuplicate(int[] nums) {
        //1 3 4 2 2 --> 5
        // n =4

        // 1 2 2 2 2 --> 5
        // n=4

        //TC : O(n), SC : O(n);
        Set <Integer> set = new HashSet<>();
        for(int num : nums){
        if(set.contains(num)){
            return num;
        }
        set.add(num);
        }
        return -1;
          
    }
}