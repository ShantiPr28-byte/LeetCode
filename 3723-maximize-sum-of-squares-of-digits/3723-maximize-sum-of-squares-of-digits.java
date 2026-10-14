class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(9 * num < sum) return "";
        
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if(sum >= 9) {
                sb.append('9');
                sum -= 9;
                num--;
            } else {
                sb.append(sum);
                sum -= sum;
                num--;
            }
        }

        return sb.toString();
    }
}