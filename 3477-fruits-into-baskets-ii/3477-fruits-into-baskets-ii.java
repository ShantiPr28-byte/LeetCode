class Solution {
    int[] seg;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        seg = new int[4 * n];

        build(0, 0, n-1, baskets);

        int unplaced = 0;
        for(int i = 0; i < n; i++) {
            if(!place(0, 0, n-1, fruits[i])) {
                unplaced++;
            }
        }

        return unplaced;
    }

    private void build(int idx, int l, int r, int[] baskets) {
        if(l == r) {
            seg[idx] = baskets[l];
            return;
        }

        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;
        int mid = l + (r - l) / 2;
        build(leftChild, l, mid, baskets);
        build(rightChild, mid + 1, r, baskets);

        seg[idx] = Math.max(seg[leftChild], seg[rightChild]);
    }

    private boolean place(int idx, int l, int r, int val) {
        if(seg[idx] < val) return false; 

        if(l == r) {
            seg[idx] = 0;
            return true;
        }

        int mid = l + (r - l) / 2;
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;

        boolean placed;
        if(val <= seg[leftChild]) {
            placed = place(leftChild, l, mid, val);
        } else {
            placed = place(rightChild, mid + 1, r, val);
        }

        seg[idx] = Math.max(seg[leftChild], seg[rightChild]);
        return placed;
    }
}