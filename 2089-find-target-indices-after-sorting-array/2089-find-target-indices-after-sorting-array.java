class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List <Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int x = 0; x < nums.length; x++){
            if(nums[x] == target){
                res.add(x);
            }
        }
        return res;
    }
}