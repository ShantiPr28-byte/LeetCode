class Solution {
    public int addDigits(int num) {
        while(num >= 10) {
            int x = num;
            int sum = 0;

            while(x > 0) {
                int digit = x % 10;
                sum += digit;
                x /= 10;
            }

            num = sum;
        }

        return num;
    }
}