class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = -1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            int count = freq[i] / 2;

            while(count-- > 0) {
                sb.append((char)(i + 'a'));
            }

            if(freq[i] % 2 != 0) {
                odd = i;
            }
        }

        String reverse = new StringBuilder(sb).reverse().toString();

        if(odd != -1) {
            sb.append((char)(odd + 'a'));
        }

        sb.append(reverse);

        return sb.toString();
    }

    
}