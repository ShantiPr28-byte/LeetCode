class Solution {
    public int minimumPushes(String word) {
        int len = word.length();

        if(len <= 8) return len;

        if(len <= 16) {
            int remain = len - 8;
            return 8 + remain * 2;
        }

        if(len <= 24) {
            int remain = len - 16;
            return 8 + 16 + remain * 3;
        }

        if(len == 25) {
            return 8 + 16 + 24 + 4;
        }

        return 8 + 16 + 24 + 8;
    }
}