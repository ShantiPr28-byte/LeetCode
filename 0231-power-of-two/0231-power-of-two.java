class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        int base = 2;
        double ans = Math.log(n) / Math.log(base);

        return Math.abs(ans - Math.round(ans)) < 1e-10;
    }
}