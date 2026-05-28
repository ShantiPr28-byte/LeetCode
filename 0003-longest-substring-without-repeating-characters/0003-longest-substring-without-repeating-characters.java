class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        int i = 0;
        for(int j = 0; j < n; j++) {
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}