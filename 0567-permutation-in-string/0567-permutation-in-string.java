class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) return false;

        int[] s1Freq = new int[26];
        int[] winFreq = new int[26];

        for(int i = 0; i < len1; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            winFreq[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(winFreq, s1Freq)) return true;

        for(int i = len1; i < len2; i++) {
            winFreq[s2.charAt(i - len1) - 'a']--;
            winFreq[s2.charAt(i) - 'a']++;

            if(Arrays.equals(winFreq, s1Freq)) return true;
        }

        return false;
    }
}