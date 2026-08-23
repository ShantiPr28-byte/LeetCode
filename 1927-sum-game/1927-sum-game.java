class Solution {
    public boolean sumGame(String num) {
        int s1 = 0, s2 = 0;
        int c1 = 0, c2 = 0;

        for(int i = 0; i < num.length() / 2; i++) {
            int ch = num.charAt(i);

            if(ch == '?') {
                c1++;
            } else {
                s1 += ch - '0';
            }
        }

        for(int i = num.length() / 2; i < num.length(); i++) {
            int ch = num.charAt(i);

            if(ch == '?') {
                c2++;
            } else {
                s2 += ch - '0';
            }
        }

        if((c1 + c2) % 2 == 1) return true;

        return s1 - s2 != 9 * (c2 - c1) / 2;
    }
}