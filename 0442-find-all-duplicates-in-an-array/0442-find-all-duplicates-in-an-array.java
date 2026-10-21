class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        List <Integer> res = new ArrayList<>();

        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );

            if(map.get(nums[i])== 2){
                res.add(nums[i]);
            }
           // map.get(i);
        }
        return res;
    }
}