class Solution {

    String s;
    Pair[][][][] memo;

    static class Pair {
        long cnt;
        long wav;

        Pair(long c, long w) {
            cnt = c;
            wav = w;
        }
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        s = Long.toString(x);
        memo = new Pair[s.length()][11][11][2];

        return dfs(0, 10, 10, false, true).wav;
    }

    private Pair dfs(int pos, int prev1, int prev2,
                     boolean started, boolean tight) {

        if (pos == s.length()) {
            return new Pair(started ? 1 : 0, 0);
        }

        if (!tight && memo[pos][prev1][prev2][started ? 1 : 0] != null)
            return memo[pos][prev1][prev2][started ? 1 : 0];

        int limit = tight ? s.charAt(pos) - '0' : 9;

        long count = 0;
        long waviness = 0;

        for (int d = 0; d <= limit; d++) {

            boolean ntight = tight && (d == limit);

            if (!started && d == 0) {
                Pair p = dfs(pos + 1, 10, 10,
                             false, ntight);

                count += p.cnt;
                waviness += p.wav;
            } else {

                int contrib = 0;

                if (started && prev1 != 10) {
                    if ((prev2 > prev1 && prev2 > d) ||
                        (prev2 < prev1 && prev2 < d))
                        contrib = 1;
                }

                int np1, np2;

                if (!started) {
                    np1 = 10;
                    np2 = d;
                } else if (prev1 == 10) {
                    np1 = prev2;
                    np2 = d;
                } else {
                    np1 = prev2;
                    np2 = d;
                }

                Pair p = dfs(pos + 1, np1, np2,
                             true, ntight);

                count += p.cnt;
                waviness += p.wav + 1L * contrib * p.cnt;
            }
        }

        Pair ans = new Pair(count, waviness);

        if (!tight)
            memo[pos][prev1][prev2][started ? 1 : 0] = ans;

        return ans;
    }
}