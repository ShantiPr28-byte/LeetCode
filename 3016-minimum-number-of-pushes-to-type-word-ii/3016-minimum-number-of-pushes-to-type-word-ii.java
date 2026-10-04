class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        reverse(freq);

        int ans = 0;

        for(int i = 0; i <= 7; i++) {
            if(freq[i] == 0) break;
            ans += freq[i];
        }

        for(int i = 8; i <= 15; i++) {
            if(freq[i] == 0) break;
            ans += (freq[i] * 2);
        }

        for(int i = 16; i <= 23; i++) {
            if(freq[i] == 0) break;
            ans += (freq[i] * 3);
        }

        for(int i = 24; i < 26; i++) {
            ans += (freq[i] * 4);
        }

        return ans;
    }

    private void reverse(int[] freq) {
        int left = 0, right = 25;

        while(left < right) {
            int temp = freq[left];
            freq[left] = freq[right];
            freq[right] = temp;

            left++;
            right--;
        }
    }
}