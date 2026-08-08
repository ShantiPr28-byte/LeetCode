class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] next = new int[m];
        Arrays.fill(next, -1);

        int i = n - 1;
        int j = m - 1;
        while(i >= 0 && j >= 0) {
            if(word1.charAt(i) == word2.charAt(j)) {
                next[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];
        int index = 0;
        j = 0;
        boolean used = false;

        for(i = 0; i < n && j < m; i++) {
            if(word1.charAt(i) == word2.charAt(j)) {
                ans[index++] = i;
                j++;
            } else if(!used && (j == m - 1 || i < next[j+1])) {
                ans[index++] = i;
                j++;
                used = true;
            }
        }

        if(j == m) return ans;

        return new int[]{};
    }
}