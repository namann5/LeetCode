class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Store the best answer
        String ans = null;

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int targetIdx = target.charAt(i) - 'a';

            // At this position, try smallest character > target[i]
            for (int j = targetIdx + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    StringBuilder candidate = new StringBuilder(prefix);

                    candidate.append((char) ('a' + j));

                    freq[j]--;

                    // Fill remaining chars in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            candidate.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    // Restore frequency
                    for (int k = i + 1; k < n; k++) {
                        // candidate creation changed freq,
                        // easier to rebuild below
                    }

                    // Instead of restoration, compare and rebuild freq
                    if (ans == null || candidate.toString().compareTo(ans) < 0) {
                        ans = candidate.toString();
                    }

                    // Rebuild frequency from scratch
                    freq = new int[26];

                    for (char c : s.toCharArray()) {
                        freq[c - 'a']++;
                    }

                    for (int p = 0; p < prefix.length(); p++) {
                        freq[prefix.charAt(p) - 'a']--;
                    }

                    break;
                }
            }

            // Exact match
            if (freq[targetIdx] == 0) {
                break;
            }

            prefix.append(target.charAt(i));
            freq[targetIdx]--;
        }

        return ans == null ? "" : ans;
    }
}