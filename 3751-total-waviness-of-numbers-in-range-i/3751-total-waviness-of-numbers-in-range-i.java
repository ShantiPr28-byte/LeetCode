class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans  = 0;

        for(int num = num1; num <= num2; num++) {
            ans += waviness(num);
        }

        return ans;
    }

    private int waviness(int num) {
        String s = Integer.toString(num);
        int count = 0;

        if(s.length() < 3) return count;

        for(int i = 1; i < s.length() - 1; i++) {
            int left = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';

            if(left < curr && right < curr || left > curr && right > curr) {
                count++;
            }
        }

        return count;
    }
}