class Solution {
    public int maximumLengthSubstring(String s) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                int idx = s.charAt(j) - 'a';
                freq[idx]++;

                if (freq[idx] > 2) {
                    break;
                }

                ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }
}