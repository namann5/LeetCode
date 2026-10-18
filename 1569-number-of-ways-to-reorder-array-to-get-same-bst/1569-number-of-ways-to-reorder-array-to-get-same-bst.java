import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb;

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        Node root = new Node(nums[0]);

        for (int i = 1; i < n; i++) {
            insert(root, nums[i]);
        }

        return (int) ((ways(root) - 1 + MOD) % MOD);
    }

    private void insert(Node root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new Node(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(val);
            } else {
                insert(root.right, val);
            }
        }
    }

    private long ways(Node root) {
        if (root == null) {
            return 1;
        }

        int leftSize = size(root.left);
        int rightSize = size(root.right);

        long leftWays = ways(root.left);
        long rightWays = ways(root.right);

        long total = comb[leftSize + rightSize][leftSize];
        total = total * leftWays % MOD;
        total = total * rightWays % MOD;

        return total;
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }
}