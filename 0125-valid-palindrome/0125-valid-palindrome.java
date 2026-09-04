class Solution {
    public boolean isPalindrome(String s) {
        return solve(0, s.length() - 1, s);
    }

    private boolean solve(int i, int j, String s) {
        if(i >= j) return true;

        if(!Character.isLetterOrDigit(s.charAt(i))) {
            return solve(i + 1, j, s);
        }

        if(!Character.isLetterOrDigit(s.charAt(j))) {
            return solve(i, j - 1, s);
        }

        if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
            return false;
        }

        return solve(i + 1, j - 1, s);
    }
}