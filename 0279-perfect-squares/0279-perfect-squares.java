class Solution {
    public int numSquares(int n) {
        if(isSquare(n)) return 1;

        for(int i = 1; i * i <= n; i++) {
            int x = n - i * i;
            if(isSquare(x)) return 2;
        }

        while(n % 4 == 0) n /= 4;

        if(n % 8 == 7) return 4;

        return 3;
    }

    private boolean isSquare(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }
}