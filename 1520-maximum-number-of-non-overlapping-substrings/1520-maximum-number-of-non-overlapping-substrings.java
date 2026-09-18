class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if(first[c] == -1)
                first[c] = i;

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {

            int c = s.charAt(i) - 'a';

            if(first[c] != i)
                continue;

            int end = last[c];
            boolean valid = true;

            for(int j = i; j <= end; j++) {

                int x = s.charAt(j) - 'a';

                if(first[x] < i) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[x]);
            }

            if(valid)
                intervals.add(new int[]{i, end});
        }

        // Sort by ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int prev = -1;

        for(int[] interval : intervals) {

            if(interval[0] > prev) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                prev = interval[1];
            }
        }

        return ans;
    }
}