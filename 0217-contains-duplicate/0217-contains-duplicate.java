class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> set = new HashSet<>();
        boolean d = false;

        for(int x : nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}