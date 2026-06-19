class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int maxAlt = 0;

        for(int i : gain) {
            alt += i;
            maxAlt = Math.max(maxAlt, alt);
        }

        return maxAlt;
    }
}