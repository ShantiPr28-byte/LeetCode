class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int open = 0;
        int close = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if(close % 2 != 0) {
                    ans++;
                    close--;
                }
                close += 2;
            } else {
                close--;
            }

            if(close < 0) {
                open++;
                close = 1;
            }
        }

        return ans + open + close;
    }
}