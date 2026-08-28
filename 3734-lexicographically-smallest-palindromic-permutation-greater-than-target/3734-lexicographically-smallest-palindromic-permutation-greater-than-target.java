import java.util.*;

class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int m = n / 2;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check if palindrome permutation is possible
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) return "";

        // Characters available for left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String prefix = target.substring(0, m);

        StringBuilder half = new StringBuilder();

        // Try matching target's left half
        int i = 0;

        for (; i < m; i++) {
            int x = prefix.charAt(i) - 'a';

            if (halfFreq[x] > 0) {
                half.append(prefix.charAt(i));
                halfFreq[x]--;
            } else {
                break;
            }
        }

        // CASE 1:
        // We matched the complete left half
        if (i == m) {

            String same = buildPalindrome(half.toString(), mid, n);

            if (same.compareTo(target) > 0) {
                return same;
            }
        }

        // CASE 2:
        // At mismatch position, try character > target[i]
        if (i < m) {

            int need = prefix.charAt(i) - 'a';

            for (int c = need + 1; c < 26; c++) {

                if (halfFreq[c] > 0) {

                    StringBuilder result = new StringBuilder(half);

                    result.append((char) ('a' + c));
                    halfFreq[c]--;

                    addRemaining(result, halfFreq);

                    return buildPalindrome(
                        result.toString(), mid, n
                    );
                }
            }
        }

        // CASE 3:
        // Backtrack from right to left
        for (int j = half.length() - 1; j >= 0; j--) {

            char removed = half.charAt(j);

            // Put removed character back
            halfFreq[removed - 'a']++;

            half.deleteCharAt(j);

            int current = removed - 'a';

            // Find smallest available character > current
            for (int c = current + 1; c < 26; c++) {

                if (halfFreq[c] > 0) {

                    StringBuilder result =
                        new StringBuilder(half);

                    result.append((char) ('a' + c));

                    int[] temp = halfFreq.clone();
                    temp[c]--;

                    addRemaining(result, temp);

                    return buildPalindrome(
                        result.toString(), mid, n
                    );
                }
            }
        }

        return "";
    }


    private void addRemaining(
        StringBuilder sb,
        int[] freq
    ) {
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                sb.append((char) ('a' + i));
                freq[i]--;
            }
        }
    }


    private String buildPalindrome(
        String half,
        char mid,
        int n
    ) {
        StringBuilder sb = new StringBuilder();

        sb.append(half);

        if (n % 2 == 1) {
            sb.append(mid);
        }

        for (int i = half.length() - 1; i >= 0; i--) {
            sb.append(half.charAt(i));
        }

        return sb.toString();
    }
}