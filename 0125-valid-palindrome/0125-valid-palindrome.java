class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while(i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            while(i < j && !Character.isLetterOrDigit(left)) {
                i++;
                left = s.charAt(i);
            }
            while(i < j && !Character.isLetterOrDigit(right)) {
                j--;
                right = s.charAt(j);
            }

            if(Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}