class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;

        boolean oddFound = false;
        for(int val : map.values()) {
            if(val % 2 == 0) {
                ans += val;
            } else {
                ans += val - 1;
                oddFound = true;
            }
        }

        return (oddFound) ? ans + 1 : ans;
    }
}