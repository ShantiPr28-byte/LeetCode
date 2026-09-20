class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len2 < len1) return false;

        int[] freq1 = new int[26];
        for(char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for(int i = 0; i <= len2 - len1; i++) {
            int[] winFreq = new int[26];

            for(int j = i; j < i + len1; j++) {
                char ch = s2.charAt(j);
                winFreq[ch - 'a']++;
            }

            if(Arrays.equals(winFreq, freq1)) return true;
        }

        return false;
    }
}