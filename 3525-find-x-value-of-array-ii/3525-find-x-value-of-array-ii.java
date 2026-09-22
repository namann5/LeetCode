class Solution {

    int k;
    int[][] cnt;
    int[] prod;
    int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;
        this.n = nums.length;

        cnt = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for(int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value % k);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.cnt[x];
        }

        return ans;
    }

    void build(int node, int low, int high, int[] nums) {

        if(low == high) {
            int r = nums[low] % k;

            prod[node] = r;
            cnt[node][r] = 1;

            return;
        }

        int mid = (low + high) / 2;

        build(node * 2, low, mid, nums);
        build(node * 2 + 1, mid + 1, high, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void update(int node, int low, int high, int index, int value) {

        if(low == high) {

            prod[node] = value;

            for(int r = 0; r < k; r++) {
                cnt[node][r] = 0;
            }

            cnt[node][value] = 1;

            return;
        }

        int mid = (low + high) / 2;

        if(index <= mid)
            update(node * 2, low, mid, index, value);
        else
            update(node * 2 + 1, mid + 1, high, index, value);

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {

        for(int r = 0; r < k; r++) {
            cnt[node][r] = cnt[left][r];
        }

        for(int r = 0; r < k; r++) {

            int rem = (prod[left] * r) % k;

            cnt[node][rem] += cnt[right][r];
        }

        prod[node] = (prod[left] * prod[right]) % k;
    }

    Node query(int node, int low, int high, int ql, int qr) {

        if(ql <= low && high <= qr) {
            return new Node(prod[node], cnt[node]);
        }

        int mid = (low + high) / 2;

        if(qr <= mid)
            return query(node * 2, low, mid, ql, qr);

        if(ql > mid)
            return query(node * 2 + 1, mid + 1, high, ql, qr);

        Node left = query(node * 2, low, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, high, ql, qr);

        return combine(left, right);
    }

    Node combine(Node left, Node right) {

        Node res = new Node();

        res.prod = (left.prod * right.prod) % k;

        for(int r = 0; r < k; r++) {
            res.cnt[r] = left.cnt[r];
        }

        for(int r = 0; r < k; r++) {

            int rem = (left.prod * r) % k;

            res.cnt[rem] += right.cnt[r];
        }

        return res;
    }

    class Node {

        int prod;
        int[] cnt;

        Node() {
            cnt = new int[k];
        }

        Node(int prod, int[] arr) {
            this.prod = prod;
            this.cnt = arr.clone();
        }
    }
}