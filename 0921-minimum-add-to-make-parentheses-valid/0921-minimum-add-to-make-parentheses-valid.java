class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int open = 0;
        int close = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') open++;
            if(ch == ')') close++;

            if(close > open) {
                ans += (close - open);
                close = 0;
                open = 0;
            }
        }

        return ans + open - close;
    }
}