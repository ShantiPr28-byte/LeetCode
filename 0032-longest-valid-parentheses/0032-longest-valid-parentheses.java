class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int open = 0;
        int close = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') open++;
            else close++;

            if(open == close) {
                ans = Math.max(ans, 2 * close);
            } else if(close > open) {
                close = 0;
                open = 0;
            }
        }

        open = 0;
        close = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch == '(') open++;
            else close++;

            if(open == close) {
                ans = Math.max(ans, 2 * open);
            } else if(open > close) {
                open = 0;
                close = 0;
            }
        }

        return ans;
    }
}