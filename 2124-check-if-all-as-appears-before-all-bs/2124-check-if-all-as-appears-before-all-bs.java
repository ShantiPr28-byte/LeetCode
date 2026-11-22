class Solution {
    public boolean checkString(String s) {
        boolean isB = false;

        for(char ch : s.toCharArray()) {
            if(ch == 'b') {
                isB = true;
            }
            if(isB && ch == 'a') {
                return false;
            } 
        }

        return true;
    }
}