class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[i] = maximum number of characters
        // of word2 that can be matched using word1[i...n-1]
        int[] suf = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            suf[i] = suf[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        boolean mismatch = false;

        while (i < n && j < m) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                i++;
                j++;
            }

            // Use our one allowed mismatch
            else if (!mismatch && suf[i + 1] >= m - j - 1) {

                ans[j] = i;
                i++;
                j++;
                mismatch = true;
            }

            // Current index cannot be used
            else {
                i++;
            }
        }

        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}