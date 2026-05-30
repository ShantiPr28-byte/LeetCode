class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] target = new int[128];
        int[] window = new int[128];

        for(char ch : t.toCharArray()) {
            target[ch]++;
        }

        int required = t.length();
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window[ch]++;

            if(window[ch] <= target[ch]) {
                formed++;
            }

            while(formed == required) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if(window[leftChar] < target[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}