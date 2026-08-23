class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (i < n / 2) {
                if (ch == '?') leftQ++;
                else leftSum += ch - '0';
            } else {
                if (ch == '?') rightQ++;
                else rightSum += ch - '0';
            }
        }

        // Odd number of '?' -> Alice wins
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }

        // Check if Bob can make both halves equal
        return 2 * (leftSum - rightSum) != 9 * (rightQ - leftQ);
    }
}