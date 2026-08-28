class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int c1 = 0;
        int c2 = 1;

        int count1 = 0;
        int count2 = 0;

        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == c1) {
                count1++;
            }
            else if (num == c2) {
                count2++;
            }
            else if (count1 == 0) {
                c1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                c2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == c1) {
                count1++;
            }
            else if (nums[i] == c2) {
                count2++;
            }
        }

        

        if (count1 > nums.length / 3) {
            ans.add(c1);
        }

        if (count2 > nums.length / 3) {
            ans.add(c2);
        }

        return ans;
    }
}