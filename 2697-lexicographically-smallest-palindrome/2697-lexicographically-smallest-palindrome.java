class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            char ch = (char) Math.min(arr[i], arr[j]);
            arr[i++] = ch;
            arr[j--] = ch;
        }

        return new String(arr);
    }
}