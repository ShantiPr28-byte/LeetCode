class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(9 * num < sum) return "";
        
        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        for(int i = 0; i < nines; i++) {
            sb.append('9');
        }
        int r = sum % 9;
        if(r != 0) {
            sb.append((char) (r + '0'));
        }

        int zeros = num - sb.length();
        for(int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}