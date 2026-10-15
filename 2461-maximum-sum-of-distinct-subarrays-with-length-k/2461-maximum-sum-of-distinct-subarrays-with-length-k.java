//TC and SC = O(n); worst case for SC

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap <Integer,Integer> map = new HashMap<>();
        long sum =0,    
            max =0;
            int dups =0;

            for(int i=0;i<k;i++){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i],0);
                }
                map.put(nums[i],map.get(nums[i])+1);

                sum = sum + nums[i];

                if(map.get(nums[i])>1){
                    dups = dups+1;
                }
            }
            if(dups == 0){
                max = Math.max(max,sum);
            }

            for(int i=k;i<n;i++){
                int no = nums[i];
                int ni = nums[i-k];

                if(!map.containsKey(no)){
                    map.put(no,0);
                }

                map.put(no,map.get(no)+1);
                if(map.get(no)>1){
                    dups = dups +1;
                }
                sum = sum + no;

                if(map.get(ni) > 1){
                    dups--;
                }
                 map.put(ni,map.get(ni)-1);

                 sum = sum - ni;
                 if(dups == 0){
                    max = Math.max(sum,max);
                 }
            }
            return max;
    }
}