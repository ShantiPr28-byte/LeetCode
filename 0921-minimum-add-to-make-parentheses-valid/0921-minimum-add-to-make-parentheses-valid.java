class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        int ans = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') open++;
            if(ch == ')') close++;

            if(close > open) {
                ans++;
                open++;
            }
        }

        return open - close + ans;
    }
}