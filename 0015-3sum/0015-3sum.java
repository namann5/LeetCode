class Solution {
    public void twoSum(int first, int[] nums, List<List<Integer>>res){
        int i=first+1;
        int j = nums.length-1;
        while(i<j){
            int sum = nums[first]+nums[i]+nums[j];

            if(sum > 0) j--;
            else if (sum < 0) i++;
            else {
                //triplet found 
                res.add(Arrays.asList(nums[first], nums[i], nums[j])); // nums[f,i,j];
                i++;
                j--; 
            
            while(i<j && nums[i]== nums[i-1]){
                i++;
            }
            while(i<j && nums[j] == nums[j+1]){
                j--;
            }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int f=0;f<nums.length;f++){
            if(nums[f] >0) break;

            if(f ==0 || nums[f] != nums[f-1]){
              twoSum(f,nums,res);
            }
        }
        return res;
    }
}