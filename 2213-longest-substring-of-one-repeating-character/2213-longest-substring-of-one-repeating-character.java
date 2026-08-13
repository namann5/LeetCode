class Solution {

    class Node {
        int len;
        int left;
        int right;
        int best;
        char lc;
        char rc;

        Node(int len, int left, int right, int best, char lc, char rc) {
            this.len = len;
            this.left = left;
            this.right = right;
            this.best = best;
            this.lc = lc;
            this.rc = rc;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int idx = queryIndices[i];

            arr[idx] = queryCharacters.charAt(i);

            update(1, 0, n - 1, idx);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            tree[node] =
                new Node(1, 1, 1, 1, arr[l], arr[l]);
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int idx) {

        if (l == r) {
            tree[node] =
                new Node(1, 1, 1, 1, arr[l], arr[l]);
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx);
        } else {
            update(node * 2 + 1, mid + 1, r, idx);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {

        int len = a.len + b.len;

        int left = a.left;
        int right = b.right;

        int best = Math.max(a.best, b.best);

        if (a.rc == b.lc) {

            best = Math.max(best, a.right + b.left);

            if (a.left == a.len) {
                left = a.len + b.left;
            }

            if (b.right == b.len) {
                right = b.len + a.right;
            }
        }

        return new Node(
            len,
            left,
            right,
            best,
            a.lc,
            b.rc
        );
    }
}