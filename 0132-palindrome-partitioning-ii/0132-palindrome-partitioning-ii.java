class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, dp) - 1;
    }

    private int solve(int idx, String s, int[] dp) {
        if(idx == s.length()) {
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int min = Integer.MAX_VALUE;

        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(idx, i, s)) {
                int partitions = 1 + solve(i + 1, s, dp);

                min = Math.min(min, partitions);
            }
        }

        return dp[idx] = min;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}