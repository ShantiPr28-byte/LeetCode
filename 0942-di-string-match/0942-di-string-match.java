class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int max = n;
        int min = 0;

        int i = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'I') {
                ans[i++] = min++;
            } else {
                ans[i++] = max--;
            }
        }

        ans[i] = min++;

        return ans;
    }
}