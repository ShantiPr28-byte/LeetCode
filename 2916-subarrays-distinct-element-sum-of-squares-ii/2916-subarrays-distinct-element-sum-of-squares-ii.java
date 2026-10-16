
class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum, sq, lazy;
    int n;

    void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) return;

        int mid = (l + r) / 2;
        long v = lazy[node];

        apply(node * 2, l, mid, v);
        apply(node * 2 + 1, mid + 1, r, v);

        lazy[node] = 0;
    }

    void apply(int node, int l, int r, long v) {
        long len = r - l + 1L;

        sq[node] = (sq[node] + 2 * v % MOD * sum[node]
                    + v * v % MOD * len) % MOD;

        sum[node] = (sum[node] + v * len) % MOD;
        lazy[node] += v;
    }

    void update(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        push(node, l, r);
        int mid = (l + r) / 2;

        update(node * 2, l, mid, ql, qr);
        update(node * 2 + 1, mid + 1, r, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n + 5];
        sq = new long[4 * n + 5];
        lazy = new long[4 * n + 5];

        java.util.Map<Integer, Integer> last = new java.util.HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], 0);

            update(1, 1, n, prev + 1, i + 1);

            ans = (ans + sq[1]) % MOD;
            last.put(nums[i], i + 1);
        }

        return (int) ans;
    }
}
