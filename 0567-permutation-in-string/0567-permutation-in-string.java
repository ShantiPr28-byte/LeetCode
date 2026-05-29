class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();

        if(n < m) return false;

        int[] s1Freq = new int[26];
        int[] winFreq = new int[26];

        for(int i = 0; i < m; i++) {
            winFreq[s2.charAt(i) - 'a']++;
            s1Freq[s1.charAt(i) - 'a']++;
        }

        if(Arrays.equals(winFreq, s1Freq)) return true;

        for(int i = m; i < n; i++) {
            winFreq[s2.charAt(i - m) - 'a']--;
            winFreq[s2.charAt(i) - 'a']++;

            if(Arrays.equals(winFreq, s1Freq)) return true;
        }

        return false;
    }
}