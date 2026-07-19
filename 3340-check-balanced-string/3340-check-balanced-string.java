class Solution {
    public boolean isBalanced(String num) {
        int evenSum = 0;
        int oddSum = 0;

        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            if(i % 2 == 0) {
                evenSum += ch - '0';
            } else {
                oddSum += ch - '0';
            }
        }

        return evenSum == oddSum;
    }
}