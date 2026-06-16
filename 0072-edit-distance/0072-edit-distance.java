class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[] prev = new int[n2 + 1];

        for(int j = 0; j <= n2; j++) {
            prev[j] = j;
        }

        for(int i = 1; i <= n1; i++) {
            int[] curr = new int[n2 + 1];
            curr[0] = i;
            for(int j = 1; j <= n2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j-1];
                } else {
                    curr[j] = 1 + Math.min(Math.min(prev[j], curr[j-1]), prev[j-1]);
                }
            }
            prev = curr;
        }

        return prev[n2];
    }
}